package com.example.SpringBank.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static com.example.SpringBank.Helpers.checkClassHasField;

@SpringBootTest
public class UserTests {
    @Test
    void hasLoginCredentials() {
        checkClassHasField(User.class, "username", String.class);
        checkClassHasField(User.class, "passwordHash", String.class);
    }
}
