package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.dto.WalletTransactionDto;

public interface WalletTransactionService {
    void createNewWalletTransaction(WalletTransactionDto walletTransactionDto);
}
