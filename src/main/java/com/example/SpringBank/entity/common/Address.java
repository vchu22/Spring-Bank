package com.example.SpringBank.entity.common;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}