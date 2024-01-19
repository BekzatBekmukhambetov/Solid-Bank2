package com.example.solidbank2.CLI;

import com.example.solidbank2.domain.BankCore;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.service.AccountListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

        List<Account> clientAccounts = accountListingService.getClientAccounts(clientID);

        if (clientAccounts != null && !clientAccounts.isEmpty()) {
            for (Account account : clientAccounts) {
                System.out.println(account);
            }
        } else {
            System.out.println("No accounts found for the client with ID: " + clientID);
        }

    }
}
