package com.example.solidbank2.CLI;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountDeposit;
import com.example.solidbank2.service.AccountListingService;
import com.example.solidbank2.transaction.TransactionDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;


@Component
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    @Autowired
    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void depositMoney(String account_id,Double amount)throws Exception , AccountNotFoundException {
       Account account =  accountListingService.getClientAccount(account_id,"1");
       transactionDeposit.execute(account,amount);
    }
}
