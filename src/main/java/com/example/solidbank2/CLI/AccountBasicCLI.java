package com.example.solidbank2.CLI;

import com.example.solidbank2.domain.BankCore;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.service.AccountListingService;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class AccountBasicCLI {
    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListingService;


    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListingService) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListingService = accountListingService;
    }

    public void createAccountRequest(AccountType accountType, String clientID){
        bankCore.createNewAccount(accountType,clientID);
    }

    public List<Account> getAccounts(String clientID) {
        return accountListingService.getClientAccounts(clientID);
    }

    public Account getAccount(String account_id) throws AccountNotFoundException {
        return accountListingService.getClientAccount(account_id,"1");
    }
}
