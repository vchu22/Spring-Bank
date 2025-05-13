package com.example.SpringBank.entity;

import com.example.SpringBank.common.Helpers;
import org.junit.jupiter.api.Test;

import static com.example.SpringBank.common.Helpers.checkClassHasField;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTests {
    /**
     * Check if <code>Employee</code> is a subclass of <code>User</code>
     * @result Pass if <code>Employee</code> is inherited from <code>User</code>, else the test will fail.
     */
    @Test
    void isSubclassOfUser() {
        assertTrue(User.class.isAssignableFrom(Employee.class), "Employee should inherit from User");
    }

    @Test
    void hasDepartmentAndRoleEnums() {
        Helpers.checkClassHasEnum(Employee.class, "Role", new String[]{"TELLER", "MANAGER", "ACCOUNTANT"});
        Helpers.checkClassHasEnum(Employee.class, "Department", new String[] { "IT", "CUSTOMER_SERVICE", "OPERATIONS", "RISK_MANAGEMENT", "LEGAL", "ACCOUNT_MANAGEMENT", "LOAN" });
    }

    /**
     * Ensures the Employee entity class has HR related fields
     * @result Test will pass if Employee class contains <code>empId</code>, <code>role</code>, and <code>department</code>.
     *          Otherwise, the test will fail.
     */
    @Test
    void hasEmpIdAndDepartment() {
        checkClassHasField(Employee.class, "empId", String.class);
        checkClassHasField(Employee.class, "role", Employee.Role.class);
        checkClassHasField(Employee.class, "department", Employee.Department.class);
    }
}
