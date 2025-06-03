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
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(unique = true, nullable = false)
    private String cardNumber;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private CardType cardType;
    public enum CardType {
        DEBIT, CREDIT
    }

    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status {
        ACTIVE, BLOCKED, EXPIRED
    }
    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account accountId;
    private float balance;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
