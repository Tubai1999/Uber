package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.entities.Payment;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.enums.PaymentStatus;

public interface PaymentService {
    void processPayment(Ride ride);
    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
