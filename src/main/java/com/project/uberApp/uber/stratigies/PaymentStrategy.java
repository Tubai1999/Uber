package com.project.uberApp.uber.stratigies;

import com.project.uberApp.uber.entities.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);
}
