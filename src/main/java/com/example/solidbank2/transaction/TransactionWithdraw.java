package com.example.solidbank2.transaction;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountWithdraw;
import com.example.solidbank2.service.AccountWithdrawService;
import com.example.solidbank2.dao.TransactionDAO;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account accountWithdraw, double amount){
        accountWithdrawService.withdraw(accountWithdraw,amount);
    }
}
