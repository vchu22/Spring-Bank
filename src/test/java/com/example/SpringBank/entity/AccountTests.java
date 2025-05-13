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
     * Ensures the <code>Account</code> entity class has the fields necessary for account operations.
     * @result Test will pass if <code>Account</code> contains the field necessary for account operations. Otherwise,
     *          the test will fail.
     */
    @Test
    void hasAccountFields() {
        checkClassHasField(Account.class, "accountNumber", String.class);
        checkClassHasField(Account.class, "accountType", String.class);
        checkClassHasField(Account.class, "balance", float.class);
        checkClassHasField(Account.class, "closed", boolean.class);
    }

    /**
     * Ensures the <code>Account</code> class has a time stamp for the time of creation.
     * @result Test will pass if <code>Account</code> contains <code>createdAt</code> timestamp. Otherwise, the test
     *          will fail.
     */
    @Test
    void hasCreatedTimestamp() throws NoSuchFieldException {
        checkClassHasField(Account.class, "createdAt", LocalDateTime.class);
        checkFieldHasAnnotation(Account.class, "createdAt", CreationTimestamp.class);
    }
}
