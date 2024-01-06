package com.example.solidbank2.service;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(Account account, double amount);
}
