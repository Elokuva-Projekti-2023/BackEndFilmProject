package ohjelmointi2.BackEndFilmApp.web;

import java.io.FileInputStream;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

@Configuration
public class FirebaseConfig {

    @Value("${firebase.serviceAccountJsonPath}")
    private String serviceAccountJsonPath;

    @Value("${firebase.serviceAccountId}")
    private String serviceAccountId;

    @Bean
    public FirebaseAuth firebaseAuth() {
        try {

            FileInputStream serviceAccount = new FileInputStream(serviceAccountJsonPath);

            // Initialize FirebaseApp only if it hasn't been initialized before
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setServiceAccountId(serviceAccountId)
                        .build();

                FirebaseApp.initializeApp(options);
            }

            return FirebaseAuth.getInstance();
        } catch (IOException e) {
            throw new RuntimeException("Error initializing Firebase Auth", e);
        }
    } 
    
}
