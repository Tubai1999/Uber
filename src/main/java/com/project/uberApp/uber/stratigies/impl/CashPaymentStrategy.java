package com.project.uberApp.uber.stratigies.impl;

import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Payment;
import com.project.uberApp.uber.entities.enums.PaymentStatus;
import com.project.uberApp.uber.entities.enums.TransactionMethod;
import com.project.uberApp.uber.repositories.PaymentRepository;
import com.project.uberApp.uber.sevices.PaymentService;
import com.project.uberApp.uber.sevices.WalletService;
import com.project.uberApp.uber.stratigies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {
    private final WalletService walletService;
//    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
//        Wallet driverWallet = walletService.findByUser(driver.getUser());
        double platformCommission = payment.getAmount()*PLATFORM_COMMISSION;
        walletService.deductMoneyFromWallet(driver.getUser(),platformCommission,
                null,payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
