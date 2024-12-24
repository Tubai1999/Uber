package com.project.uberApp.uber.dto;

import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.Wallet;
import com.project.uberApp.uber.entities.enums.TransactionMethod;
import com.project.uberApp.uber.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class WalletTransactionDto {

    private Long id;

    private Double amount;
    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDto ride;

    private String transactionId;
    private WalletDto wallet;

    private LocalDateTime timeStamp;
}
