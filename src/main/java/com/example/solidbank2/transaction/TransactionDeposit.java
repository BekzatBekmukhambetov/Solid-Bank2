package com.example.solidbank2.transaction;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountDeposit;
import com.example.solidbank2.domain.account.AccountWithdraw;
import com.example.solidbank2.dao.TransactionDAO;
import com.example.solidbank2.service.AccountDepositService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }
    public void execute(Account account, double amount){
        accountDepositService.deposit(account,amount);
    }
}
