package com.example.SpringBank.entity;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

// imports for tests
import org.junit.jupiter.api.Test;
import static com.example.SpringBank.common.Helpers.*;

public class CardTests {
    /**
     * Ensures <code>Card</code> has the enums <code>CardType</code> and <code>Status</code>.
     * @result Pass if <code>CardType</code> and <code>Status</code> enums exist in <code>Card</code>
     *          entity and have the correct values, else the test will fail.
     */
    @Test
    void hasCardTypeEnum(){
        checkClassHasEnum(Card.class, "CardType",  new String[] { "DEBIT", "CREDIT" });
        checkClassHasEnum(Card.class, "Status",  new String[] { "ACTIVE", "BLOCKED", "EXPIRED" });
    }

    /**
     * Ensures the <code>Card</code> entity class has the fields necessary for recording card information.
     * @result Test will pass if <code>Card</code> contains the field necessary for card information. Otherwise,
     *          the test will fail.
     */
    @Test
    void hasCardFields() {
        checkClassHasField(Card.class, "cardNumber", String.class);
        checkClassHasField(Card.class, "issueDate", LocalDateTime.class);
        checkClassHasField(Card.class, "expiryDate", LocalDateTime.class);
        checkClassHasField(Card.class, "cardType", Card.CardType.class);
        checkClassHasField(Card.class, "status", Card.Status.class);
        checkClassHasField(Card.class, "balance", float.class);
    }

    /**
     * Ensures the <code>cardNumber</code> is a unique key.
     * @result Test will pass if <code>accountId</code> is a unique key. Otherwise, the test will fail.
     */
    @Test
    void cardNumberIsUnique() throws NoSuchFieldException {
        isUniqueKey(Card.class, "cardNumber");
    }

    /**
     * Ensures the <code>accountId</code> is a foreign key pointing to the <code>Account</code> table.
     * @result Test will pass if <code>accountId</code> is a foreign key pointing to the <code>Account</code> table.
     *          Otherwise, the test will fail.
     */
    @Test
    void accountIdIsForeignKey() throws NoSuchFieldException {
        isForeignKey(Card.class, "accountId", Account.class, "id",
                AssociationMappingType.MANY_TO_ONE);
    }

    /**
     * Ensures the <code>Card</code> class has a time stamp for when the card entry was created.
     * @result Test will pass if <code>Card</code> contains <code>createdAt</code> timestamp. Otherwise, the test
     *          will fail.
     */
    @Test
    void hasCreatedTimestamp() throws NoSuchFieldException {
        checkClassHasField(Card.class, "createdAt", LocalDateTime.class);
        checkFieldHasAnnotation(Card.class, "createdAt", CreationTimestamp.class);
    }
}
