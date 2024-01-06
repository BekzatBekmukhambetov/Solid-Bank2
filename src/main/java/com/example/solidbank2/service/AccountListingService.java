package com.example.solidbank2.service;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);
    Account getClientWithdrawAccount(String clientID,String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountByType(String clientID, AccountType accountType);
}
