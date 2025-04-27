package com.example.SpringBank.dto;

import com.example.SpringBank.entity.common.Address;
import com.example.SpringBank.entity.common.ContactInfo;
import com.example.SpringBank.entity.common.FullName;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    protected String username;
    protected String passwordHash;
    @Embedded
    protected FullName fullName;
    @Embedded
    private Address address;
    @Embedded
    private ContactInfo contactInfo;
}
