package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.Wallet;
import com.project.uberApp.uber.entities.WalletTransaction;
import com.project.uberApp.uber.entities.enums.TransactionMethod;
import com.project.uberApp.uber.entities.enums.TransactionType;
import com.project.uberApp.uber.exceptions.ResourceNotFoundException;
import com.project.uberApp.uber.repositories.WalletRepository;
import com.project.uberApp.uber.sevices.WalletService;
import com.project.uberApp.uber.sevices.WalletTransactionService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;
    @Override

    public Wallet addMoneyToWallet(User user, Double amount,
                                   String transactionId, Ride ride
                                    , TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()+amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .transactionType(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .wallet(wallet)
                .amount(amount)
                .build();
        walletTransactionService.createNewWalletTransaction(walletTransaction);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet deductMoneyFromWallet(User user, Double amount,
                                        String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()-amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .wallet(wallet)
                .amount(amount)
                .build();
        wallet.getTransactions().add(walletTransaction);
        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {
    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("wallet not found with id :"+walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
        return walletRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("wallet not found for user with id: "+ user.getId()));
    }
}
