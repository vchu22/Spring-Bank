package com.example.SpringBank.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "employee")
public class Employee extends User {
    private String empId;

    // Enum declarations
    @Enumerated(EnumType.STRING)
    private Department department;
    public enum Department {
        IT, CUSTOMER_SERVICE, OPERATIONS, RISK_MANAGEMENT, LEGAL, ACCOUNT_MANAGEMENT, LOAN
    }
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role {
        TELLER, MANAGER, ACCOUNTANT
    }
}