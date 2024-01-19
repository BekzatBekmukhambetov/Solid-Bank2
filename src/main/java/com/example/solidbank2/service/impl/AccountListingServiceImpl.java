package com.example.solidbank2.service.impl;

import com.example.solidbank2.dao.AccountDAO;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;
import com.example.solidbank2.service.AccountListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.findAccountByClientIDAndId(accountID,clientID);
    }

    @Override
    public Account getClientWithdrawAccount(String clientID ,String accountID) {
        Account account =   accountDAO.findAccountByClientIDAndId(accountID,clientID);
        if(account.isWithdrawAllowed()){
            return  account;
        }
        return null;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.findAllAccountsById(clientID);
    }

    @Override
    public List<Account> getClientAccountByType(String clientID, AccountType accountType) {
        return null;
    }
}
