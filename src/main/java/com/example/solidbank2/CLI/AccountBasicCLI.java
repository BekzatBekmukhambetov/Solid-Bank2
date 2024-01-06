package com.example.solidbank2.CLI;

import com.example.solidbank2.domain.BankCore;
import com.example.solidbank2.service.AccountListingService;
import org.springframework.stereotype.Component;

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

    public void createAccountRequest(String clientID){
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(),clientID);
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListingService.getClientAccounts(clientID));
    }
}
