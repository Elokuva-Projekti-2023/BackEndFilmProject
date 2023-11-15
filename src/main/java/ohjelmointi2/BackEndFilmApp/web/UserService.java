package ohjelmointi2.BackEndFilmApp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String uid, String userName, String userEmail) {
        User user = new User(uid, userName, userEmail);

        // Saving user to our database
        userRepository.save(user);
    }
    
    public User getUserData(String uid) {
        // Retrieve user data from the database based on the UID
        Optional<User> userOptional = userRepository.findByfirebaseUid(uid); // using UserRepository

        return userOptional.orElse(null);
    }

}