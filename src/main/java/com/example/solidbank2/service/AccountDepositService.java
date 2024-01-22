package com.example.solidbank2.service;

import com.example.solidbank2.domain.account.Account;

import java.util.Optional;


public interface AccountDepositService {
    void deposit(Account account, double amount) throws Exception;
}
