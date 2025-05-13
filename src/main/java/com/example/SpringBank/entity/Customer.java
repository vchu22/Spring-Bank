package com.example.SpringBank.entity;
import com.example.SpringBank.entity.common.Address;
import com.example.SpringBank.entity.common.ContactInfo;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Builder
@Entity
@Table(name = "customer")
public class Customer extends User {
    @Embedded
    private Address address;
    @Embedded
    private ContactInfo contactInfo;
    private Date dateOfBirth;
    private boolean isDeceased;
}