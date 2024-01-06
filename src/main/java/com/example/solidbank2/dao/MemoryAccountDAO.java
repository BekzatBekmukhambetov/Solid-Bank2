package com.example.solidbank2.dao;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryAccountDAO implements AccountDAO {
    List<Account>accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateAccount(Account updatedAccount) {
        for(Account account : accountList){
            if(account.getClientID().equals(updatedAccount.getClientID())){
                account.setBalance(updatedAccount.getBalance());
            }
        }
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        Account account = getClientAccount(clientID,accountID);
        if(account.isWithdrawAllowed()){
            return  account;
        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for(Account account:accountList){
            if(account.getClientID().equals(accountID)) {
                return account;
            }
        }return  null;
    }
}
