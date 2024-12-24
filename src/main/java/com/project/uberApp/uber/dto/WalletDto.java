package com.project.uberApp.uber.dto;

import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.WalletTransaction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
public class WalletDto {
    private Long id;
    private UserDto user;
    private Double balance;
    private List<WalletTransactionDto> transactions;

}
