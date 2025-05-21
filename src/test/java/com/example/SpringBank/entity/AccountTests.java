package com.example.SpringBank.entity;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

// imports for tests
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static com.example.SpringBank.common.Helpers.*;

@SpringBootTest
public class AccountTests {
    /**
     * Ensures <code>Account</code> has the enum <code>AccountType</code> with at least the Checking and Saving types.
     * @result Pass if <code>AccountType</code> enums exist in <code>Account</code> entity, else the test will fail.
     */
    @Test
    void hasAccountTypeEnum(){
        checkClassHasEnum(Account.class, "AccountType",  new String[] { "CHECKING", "SAVING" });
    }

    /**
     * Ensures the <code>Account</code> entity class has the fields necessary for account operations.
     * @result Test will pass if <code>Account</code> contains the field necessary for account operations. Otherwise,
     *          the test will fail.
     */
    @Test
    void hasAccountFields() {
        checkClassHasField(Account.class, "accountNumber", String.class);
        checkClassHasField(Account.class, "accountType", Account.AccountType.class);
        checkClassHasField(Account.class, "balance", float.class);
        checkClassHasField(Account.class, "closed", boolean.class);
    }

    /**
     * Ensures <code>Account</code> has a foreign key pointing to the <code>Customer</code> entity.
     * @result Test will pass if <code>Account</code> has a foreign key <code>customerId</code> pointing to the
     *          <code>Customer</code> entity. Otherwise, the test will fail.
     */
    @Test
    void hasForeignKeyToCustomer() throws NoSuchFieldException {
        isForeignKey(Account.class, "customerId", Customer.class, "id", AssociationMappingType.MANY_TO_ONE);
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
