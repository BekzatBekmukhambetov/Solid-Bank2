package com.example.solidbank2.service;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public interface AccountListingService {
     Account getClientAccount(String accountID, String  clientID) throws AccountNotFoundException;
    Account getClientWithdrawAccount(String accountID, String  clientID) throws Exception;
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountByType(String clientID, AccountType accountType);
    boolean deleteAccountById(String accountID);
}
