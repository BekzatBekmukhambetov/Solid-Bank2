package com.example.solidbank2.service.impl;


import com.example.solidbank2.dao.AccountDAO;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.service.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {


    AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(Account account, double amount) {
        if(amount>=0) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            System.out.println(amount + " transferred to " + account.getClientID());
            accountDAO.save(account);
        }else
            System.out.println("Error enter proper amount");
    }
}
