package com.example.SpringBank.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    public enum AccountType {
        CHECKING, SAVING, CD, MONEY_MARKET
    }
    private float balance;
    private boolean closed;

    // Timestamps
    @CreationTimestamp
    private LocalDateTime createdAt;
}
