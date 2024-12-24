package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.WalletTransactionDto;
import com.project.uberApp.uber.entities.WalletTransaction;
import com.project.uberApp.uber.repositories.WalletRepository;
import com.project.uberApp.uber.repositories.WalletTransactionRepository;
import com.project.uberApp.uber.sevices.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {
    private final ModelMapper modelMapper;
    private final WalletTransactionRepository walletTransactionRepository;
    @Override
    public void createNewWalletTransaction(WalletTransactionDto walletTransactionDto) {
        WalletTransaction walletTransaction = modelMapper.map(walletTransactionDto,WalletTransaction.class);
        walletTransactionRepository.save(walletTransaction);
    }
}
