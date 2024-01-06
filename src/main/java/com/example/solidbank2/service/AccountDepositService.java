package com.example.solidbank2.service;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import org.springframework.stereotype.Service;


public interface AccountDepositService {
    void deposit(Account account, double amount);
}
