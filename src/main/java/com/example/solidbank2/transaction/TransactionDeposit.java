package com.example.solidbank2.transaction;

import com.example.solidbank2.domain.Transaction;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.dao.TransactionDAO;
import com.example.solidbank2.service.AccountDepositService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;


    public TransactionDeposit(AccountDepositService accountDepositService,
                              TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO=transactionDAO;
    }
    public void execute(Account account, double amount)throws Exception{
        accountDepositService.deposit(account,amount);
        Transaction transaction = new Transaction(account.getClientID(),"deposit of the amount: "+amount);
        transactionDAO.save(transaction);
    }
}
