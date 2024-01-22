package com.example.solidbank2.service.impl;


import com.example.solidbank2.dao.AccountDAO;
import com.example.solidbank2.dao.TransactionDAO;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.service.AccountDepositService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {


    AccountDAO accountDAO;


    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;

    }

    @Override
    public void deposit(Account account, double amount) throws Exception {

        if(amount>=0) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            accountDAO.save(account);


        }else
            throw new Exception("Incorrect value of money");
    }
}
