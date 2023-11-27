package ohjelmointi2.BackEndFilmApp.web;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import ohjelmointi2.BackEndFilmApp.domain.RegistrationRequest;
import ohjelmointi2.BackEndFilmApp.domain.SignInRequest;
import ohjelmointi2.BackEndFilmApp.domain.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
    private FirebaseAuth firebaseAuth;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    public AuthController(FirebaseAuth firebaseAuth, UserService userService, TokenService tokenService) {
        this.firebaseAuth = firebaseAuth;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
        try {
            // Creating user to Firebase
            CreateRequest createRequest = new CreateRequest()
                    .setDisplayName(request.getUserName())
                    .setEmail(request.getEmail())
                    .setPassword(request.getPassword());

            UserRecord userRecord = firebaseAuth.createUser(createRequest);

            // Saving to our database
            userService.registerUser(userRecord.getUid(), request.getUserName(), request.getEmail());

            return ResponseEntity.ok("User registered successfully");
        } catch (FirebaseAuthException e) {
            // If user with already used email exist
            if ("email-already-exists".equals(e.getErrorCode())) {
                return ResponseEntity.status(400).body("User with this email already exists");
            } else {
                e.printStackTrace();
                return ResponseEntity.status(500).body("Registration failed");
            }
        }
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        try {
            // Validate user credentials using Firebase or your preferred authentication mechanism
            UserRecord userRecord = firebaseAuth.getUserByEmail(signInRequest.getEmail());
            
            User userData = userService.getUserData(userRecord.getUid());

            // Generate a JWT token for the user session
			String sessionToken = tokenService.generateToken(userData.getFirebaseUid(), userData.getUser_email());

			// Return user data and the session token in the response
			Map<String, Object> response = new HashMap<>();
			response.put("userData", userData);
			response.put("sessionToken", sessionToken);

			return ResponseEntity.ok(response);
        } catch (FirebaseAuthException e) {
            // Handle Firebase authentication exception
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } catch (Exception e) {
            // Log the exception details for debugging
            e.printStackTrace();
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

}