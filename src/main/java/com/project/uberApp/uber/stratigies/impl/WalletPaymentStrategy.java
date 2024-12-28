package com.project.uberApp.uber.stratigies.impl;

import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Payment;
import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.enums.PaymentStatus;
import com.project.uberApp.uber.entities.enums.TransactionMethod;
import com.project.uberApp.uber.repositories.PaymentRepository;
import com.project.uberApp.uber.sevices.PaymentService;
import com.project.uberApp.uber.sevices.WalletService;
import com.project.uberApp.uber.stratigies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {
    private final WalletService walletService;
//    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;
    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Rider rider = payment.getRide().getRider();
        Driver driver = payment.getRide().getDriver();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(),
                null, payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1-PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(), payment.getAmount(),
                null, payment.getRide(),TransactionMethod.RIDE);
        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
