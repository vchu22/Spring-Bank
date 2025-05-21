package com.example.SpringBank.entity;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

// imports for tests
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static com.example.SpringBank.common.Helpers.*;

@SpringBootTest
public class TransactionTests {
    /**
     * Ensures <code>Transaction</code> has the enums <code>TransactionType</code> and <code>Status</code>.
     * @result Pass if <code>TransactionType</code> and <code>Status</code> enums exist in <code>Transaction</code>
     *          entity and have the correct values, else the test will fail.
     */
    @Test
    void hasTransactionTypeEnum(){
        checkClassHasEnum(Transaction.class, "TransactionType",  new String[] { "DEPOSIT", "WITHDRAWAL", "TRANSFER" });
        checkClassHasEnum(Transaction.class, "Status",  new String[] { "COMPLETED", "PENDING", "CANCELED" });
    }

    /**
     * Ensures the <code>Transaction</code> entity class has the fields necessary for recording transactions.
     * @result Test will pass if <code>Transaction</code> contains the field necessary for transactions. Otherwise, the
     *          test will fail.
     */
    @Test
    void hasTransactionFields() {
        checkClassHasField(Transaction.class, "transactionType", Transaction.TransactionType.class);
        checkClassHasField(Transaction.class, "amount", float.class);
        checkClassHasField(Transaction.class, "balanceAfterTransaction", float.class);
        checkClassHasField(Transaction.class, "status", Transaction.Status.class);
        checkClassHasField(Transaction.class, "description", String.class);
    }

    /**
     * Ensures the <code>accountId</code> is a foreign key pointing to the <code>Account</code> table.
     * @result Test will pass if <code>accountId</code> is a foreign key pointing to the <code>Account</code> table.
     *          Otherwise, the test will fail.
     */
    @Test
    void accountIdIsForeignKey() throws NoSuchFieldException {
        isForeignKey(Transaction.class, "accountId", Account.class, "id", AssociationMappingType.MANY_TO_ONE);
    }

    /**
     * Ensures the <code>Transaction</code> class has a time stamp for when the transaction was initiated.
     * @result Test will pass if <code>Transaction</code> contains <code>createdAt</code> timestamp. Otherwise, the test
     *          will fail.
     */
    @Test
    void hasCreatedTimestamp() throws NoSuchFieldException {
        checkClassHasField(Transaction.class, "createdAt", LocalDateTime.class);
        checkFieldHasAnnotation(Transaction.class, "createdAt", CreationTimestamp.class);
    }
}
