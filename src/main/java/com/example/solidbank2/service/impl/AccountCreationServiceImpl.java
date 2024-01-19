package com.example.solidbank2.service.impl;

import com.example.solidbank2.dao.AccountDAO;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String accountNumber = String.format("%03d%06d", 1, accountID);

        switch (accountType) {
            case CHECKING, SAVING:
                accountDAO.save(new Account(accountType, clientID, accountNumber, 0.0, true));
                break;

            case FIXED:
                accountDAO.save(new Account(accountType, clientID, accountNumber, 0.0, false));
                break;
        }
        System.out.println("Account Created");
    }
}
