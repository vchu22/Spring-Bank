package com.example.SpringBank.entity.common;

import jakarta.persistence.Embeddable;

@Embeddable
public class FullName {
    private String firstName;
    private String middleName;
    private String lastName;

}
