package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.Wallet;
import com.project.uberApp.uber.exceptions.ResourceNotFoundException;
import com.project.uberApp.uber.repositories.WalletRepository;
import com.project.uberApp.uber.sevices.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    @Override
    public Wallet addMoneyToWallet(Long userId, Double amount) {
        return null;
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("wallet not found with id :"+walletId))
    }

    @Override
    public Wallet createNewWallet(User user) {
        return null;
    }
}
