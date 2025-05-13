package com.example.SpringBank.entity;
import static com.example.SpringBank.common.Helpers.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

// Imports for tests
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

    /**
     * Check if User class has time stamps.
     * @result Test will pass if User class contains <code>createdAt</code> and <code>modifiedAt</code>. Otherwise, the
     *          test will fail.
     */
    @Test
    void hasCreatedAndModifiedTimestamps() throws NoSuchFieldException {
        checkClassHasField(User.class, "createdAt", LocalDateTime.class);
        checkClassHasField(User.class, "modifiedAt", LocalDateTime.class);
        checkFieldHasAnnotation(User.class, "createdAt", CreationTimestamp.class);
        checkFieldHasAnnotation(User.class, "modifiedAt", UpdateTimestamp.class);
    }
}
