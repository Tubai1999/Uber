package com.project.uberApp.uber.entities;

import com.project.uberApp.uber.entities.enums.TransactionMethod;
import com.project.uberApp.uber.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;

    private String transactionId;

    @ManyToOne
    private Wallet wallet;

    @CreationTimestamp
    private LocalDateTime timeStamp;

}
