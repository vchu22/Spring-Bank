package com.example.SpringBank.entity;
import com.example.SpringBank.entity.common.*;
import java.util.Date;

// Imports for tests
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.example.SpringBank.common.Helpers.checkClassHasField;

@SpringBootTest
public class CustomerTests {
    /**
     * Ensures <code>Customer</code> is a subclass of <code>User</code>.
     * @result Pass if <code>Customer</code> is inherited from <code>User</code>, else the test will fail.
     */
    @Test
    void isSubclassOfUser() {
        assertTrue(User.class.isAssignableFrom(Customer.class), "Customer should inherit from User");
    }

    /**
     * Ensures the <code>Customer</code> entity class has the fields for address.
     * @result Test will pass if <code>Customer</code> contains the fields for address with the correct data types.
     *          Otherwise, the test will fail.
     */
    @Test
    void hasAddressFields() {
        checkClassHasField(Customer.class, "address", Address.class);
        checkClassHasField(Address.class, "addressLine1", String.class);
        checkClassHasField(Address.class, "addressLine2", String.class);
        checkClassHasField(Address.class, "city", String.class);
        checkClassHasField(Address.class, "state", String.class);
        checkClassHasField(Address.class, "postalCode", String.class);
        checkClassHasField(Address.class, "country", String.class);
    }

    /**
     * Ensures the <code>Customer</code> entity class has the fields for contact info.
     * @result Test will pass if <code>Customer</code> contains the fields for contact info with the correct types.
     *          Otherwise, the test will fail.
     */
    @Test
    void hasContactInfoFields() {
        checkClassHasField(Customer.class, "contactInfo", ContactInfo.class);
        checkClassHasField(ContactInfo.class, "email", String.class);
        checkClassHasField(ContactInfo.class, "phoneNumber", String.class);
        checkClassHasField(ContactInfo.class, "secondaryPhoneNumber", String.class);
    }

    /**
     * Ensures the <code>Customer</code> entity class has a field for date of birth.
     * @result Test will pass if <code>Customer</code> contains a Date field <code>dateOfBirth</code>. Otherwise, the
     *          test will fail.
     */
    @Test
    void hasDateOfBirthField() {
        checkClassHasField(Customer.class, "dateOfBirth", Date.class);
    }

    /**
     * Ensures the <code>Customer</code> entity class has a boolean field indicating if the customer is deceased.
     * @result Test will pass if <code>Customer</code> contains a boolean <code>isDeceased</code>. Otherwise, the test
     *          will fail.
     */
    @Test
    void hasIsDeceasedField() {
        checkClassHasField(Customer.class, "isDeceased", boolean.class);
    }
}
