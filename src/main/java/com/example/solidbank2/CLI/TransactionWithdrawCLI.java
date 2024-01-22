package com.example.solidbank2.CLI;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.service.AccountListingService;
import com.example.solidbank2.transaction.TransactionWithdraw;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String account_id,Double amount) throws Exception {
        Account account = accountListingService.getClientWithdrawAccount(account_id,"1");
        transactionWithdraw.execute(account,amount);
    }
}
