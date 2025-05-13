package com.example.SpringBank.entity;
import org.hibernate.annotations.CreationTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.example.SpringBank.common.Helpers.checkClassHasField;
import static com.example.SpringBank.common.Helpers.checkFieldHasAnnotation;

@SpringBootTest
public class AccountTests {
    /**
     * Ensures the Account entity class has the fields necessary for account operations.
     * @result Test will pass if Account class contains the field necessary for account operations. Otherwise, the
     *          test will fail.
     */
    @Test
    void hasAccountFields() {
        checkClassHasField(Account.class, "accountNumber", String.class);
        checkClassHasField(Account.class, "accountType", String.class);
        checkClassHasField(Account.class, "balance", float.class);
        checkClassHasField(Account.class, "closed", boolean.class);
    }

    /**
     * Check if Account class has time stamps.
     * @result Test will pass if Account class contains <code>createdAt</code> timestamp. Otherwise, the test will fail.
     */
    @Test
    void hasCreatedTimestamps() throws NoSuchFieldException {
        checkClassHasField(Account.class, "createdAt", LocalDateTime.class);
        checkFieldHasAnnotation(Account.class, "createdAt", CreationTimestamp.class);
    }
}
