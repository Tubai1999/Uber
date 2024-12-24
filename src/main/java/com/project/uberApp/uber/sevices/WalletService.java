package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.Wallet;

public interface WalletService {

    Wallet addMoneyToWallet(Long userId, Double amount);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);
}
