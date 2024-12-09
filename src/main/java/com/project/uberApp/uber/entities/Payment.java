package com.project.uberApp.uber.entities;

import com.project.uberApp.uber.entities.enums.PaymentMethod;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime peymentTime;

}
