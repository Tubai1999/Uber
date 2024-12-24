package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.entities.Payment;
import com.project.uberApp.uber.entities.Ride;

public interface PaymentService {
    void processPayment(Payment payment);
    Payment createNewPayment(Ride ride);
}
