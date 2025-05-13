package com.example.SpringBank.entity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.SpringBank.Helpers.*;

@SpringBootTest
public class UserTests {
    /**
     * Ensures the User entity class has the fields for login credentials.
     * @result Test will pass if User class contains the field <code>username</code> and <code>passwordHash</code> of
     *          string type. Otherwise, the test will fail.
     */
    @Test
    void hasLoginCredentials() {
        checkClassHasField(User.class, "username", String.class);
        checkClassHasField(User.class, "passwordHash", String.class);
    }

    /**
     * Ensures the User entity class is abstract.
     * @result Test will pass if User class is abstract, but will fail if User class is not.
     */
    @Test
    void userClassIsAbstract() {
        checkClassIsAbstract(User.class);
    }
}
