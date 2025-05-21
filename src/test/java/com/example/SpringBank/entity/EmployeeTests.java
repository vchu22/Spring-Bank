package com.example.SpringBank.entity;

// imports for tests
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.example.SpringBank.common.Helpers;
import static com.example.SpringBank.common.Helpers.checkClassHasField;

public class EmployeeTests {
    /**
     * Ensures <code>Employee</code> is a subclass of <code>User</code>.
     * @result Pass if <code>Employee</code> is inherited from <code>User</code>, else the test will fail.
     */
    @Test
    void isSubclassOfUser() {
        assertTrue(User.class.isAssignableFrom(Employee.class), "Employee should inherit from User");
    }

    /**
     * Ensures <code>Employee</code> has the enums <code>Department</code> and <code>Role</code> with appropriate values.
     * @result Pass if <code>Department</code> and <code>Role</code> enums exist in <code>Employee</code> entity, else
     *          the test will fail.
     */
    @Test
    void hasDepartmentAndRoleEnums() {
        Helpers.checkClassHasEnum(Employee.class, "Department", new String[] { "IT", "CUSTOMER_SERVICE", "OPERATIONS", "RISK_MANAGEMENT", "LEGAL", "ACCOUNT_MANAGEMENT", "LOAN" });
        Helpers.checkClassHasEnum(Employee.class, "Role", new String[]{"TELLER", "MANAGER", "ACCOUNTANT"});
    }

    /**
     * Ensures the <code>Employee</code> entity class has HR related fields
     * @result Test will pass if <code>Employee</code> contains <code>empId</code>, <code>role</code>, and <code>department</code>.
     *          Otherwise, the test will fail.
     */
    @Test
    void hasEmpIdAndDepartment() {
        checkClassHasField(Employee.class, "empId", String.class);
        checkClassHasField(Employee.class, "role", Employee.Role.class);
        checkClassHasField(Employee.class, "department", Employee.Department.class);
    }
}
