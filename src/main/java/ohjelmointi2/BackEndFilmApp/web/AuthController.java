package ohjelmointi2.BackEndFilmApp.web;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import ohjelmointi2.BackEndFilmApp.domain.RegistrationRequest;
import ohjelmointi2.BackEndFilmApp.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final FirebaseAuth firebaseAuth;
    private final UserService userService;

    @Autowired
    public AuthController(FirebaseAuth firebaseAuth, UserService userService) {
        this.firebaseAuth = firebaseAuth;
        this.userService = userService;
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
    public ResponseEntity<?> signInUser(@RequestBody RegistrationRequest request) {
        try {
            // Sign in with Firebase
            UserRecord userRecord = firebaseAuth.getUserByEmail(request.getEmail());

            // Implement your logic here, for example, check the provided password against the stored hash
            // ...

            // Additional actions after successful sign-in
            // ...

            // You can retrieve user data from your userService
            // Replace this with the actual method you use to get user data
            User userData = userService.getUserData(userRecord.getUid());

            // Return user data in the response
            return ResponseEntity.ok(userData);
        } catch (FirebaseAuthException e) {
            // Handle sign-in errors
            return handleSignInError(e);
        }
    }

    private ResponseEntity<String> handleSignInError(FirebaseAuthException e) {
        System.err.println("Sign-in error: " + e.getMessage());
        return ResponseEntity.status(401).body("Invalid email or password");
    }



}
