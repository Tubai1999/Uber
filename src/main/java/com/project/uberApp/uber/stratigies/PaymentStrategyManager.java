package com.project.uberApp.uber.stratigies;


import com.project.uberApp.uber.entities.enums.PaymentMethod;
import com.project.uberApp.uber.stratigies.impl.CashPaymentStrategy;
import com.project.uberApp.uber.stratigies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.project.uberApp.uber.entities.enums.PaymentMethod.CASH;
import static com.project.uberApp.uber.entities.enums.PaymentMethod.WALLET;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {
    private final CashPaymentStrategy cashPaymentStrategy;
    private final WalletPaymentStrategy walletPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        if(paymentMethod == CASH){
            return cashPaymentStrategy;
        }
//        else if(paymentMethod == WALLET) {
        else {
            return walletPaymentStrategy;
        }
    }
}
