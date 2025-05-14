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
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account accountId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    public enum TransactionType {
        DEPOSIT, WITHDRAWAL, TRANSFER, INTEREST, BONUS
    }
    private float amount;
    private float balanceAfterTransaction;
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status {
        COMPLETED, PENDING, CANCELED
    }
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
