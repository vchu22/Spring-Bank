package com.example.SpringBank.entity.common;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInfo {
    private String email;
    private String phoneNumber;
    private String secondaryPhoneNumber;
}
