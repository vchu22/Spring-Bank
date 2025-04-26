package com.example.SpringBank.entity;
import com.example.SpringBank.entity.common.Address;
import com.example.SpringBank.entity.common.ContactInfo;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends User {
    @Embedded
    private Address address;
    @Embedded
    private ContactInfo contactInfo;
    private boolean isDeceased;
}