package ohjelmointi2.BackEndFilmApp.domain;

import java.security.SecureRandom;
import java.util.Base64;

// This function does not apply to the application. It is needed to generate codes.

public class KeyGenerator {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits
        secureRandom.nextBytes(key);

        // Encode the key to Base64 for easy storage in a configuration file
        String base64Key = Base64.getEncoder().encodeToString(key);

        System.out.println("Generated Key: " + base64Key);
    }
}
