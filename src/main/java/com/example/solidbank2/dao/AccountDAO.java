package com.example.solidbank2.dao;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;

import java.util.List;


public interface AccountDAO {
    List<Account>getClientAccounts(String id);
    void createNewAccount(Account account);
    void updateAccount(Account account);
    List<Account>getClientAccountsByType(String clientID, AccountType accountType);
    Account getClientWithdrawAccount(String clientID, String accountID);
    Account getClientAccount(String clientID,String accountID);

}
