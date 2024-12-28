package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.dto.WalletTransactionDto;
import com.project.uberApp.uber.entities.WalletTransaction;

public interface WalletTransactionService {
    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
