package com.example.SpringBank.util;

// imports for tests
import org.junit.jupiter.api.Test;

public class PasswordHasherTest {

    @Test
    void canHashPasswordWithArgon2(){
        PasswordHasher ph = new PasswordHasher();
        String password = "abcd123";
        String hashedPassword = ph.hashPassword(password);
        System.out.println("Original Password: " + password + ", Hashed Password: "+ hashedPassword);
        assert ph.verifyPassword(password, hashedPassword);

        // test a different password
        password = "ZYX567890CBA";
        hashedPassword = ph.hashPassword(password);
        System.out.println("Original Password: " + password + ", Hashed Password: "+ hashedPassword);
        assert ph.verifyPassword(password, hashedPassword);
    }
}
