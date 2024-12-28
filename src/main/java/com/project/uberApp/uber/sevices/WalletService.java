package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.Wallet;
import com.project.uberApp.uber.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount,
                            String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount,
                                 String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
