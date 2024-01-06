package com.example.solidbank2.domain;

import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static  long id =1;
    private long lastAccountNumber =1;

    AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }
    public void createNewAccount(AccountType accountType, String clientID){
        accountCreation.create(accountType,id,clientID,lastAccountNumber);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber(){
        lastAccountNumber++;
    }
}
