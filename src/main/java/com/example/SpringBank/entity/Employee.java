package com.example.SpringBank.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "employee")
public class Employee extends User {
    private String empId;
    private String department;
    @Enumerated(EnumType.STRING)
    protected Role role;
    public enum Role {
        TELLER,
        MANAGER,
        ACCOUNTANT
    }
}