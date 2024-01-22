package com.example.solidbank2.service.impl;

import com.example.solidbank2.dao.AccountDAO;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.service.AccountListingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account  getClientAccount(String accountID, String  clientID) throws AccountNotFoundException {
        //accountId  = 001001 client =1
        return accountDAO.findAccountByClientIDAndId(accountID, clientID).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Override
    public Account getClientWithdrawAccount(String accountID, String  clientID) throws Exception {
        Optional<Account> account = accountDAO.findAccountByClientIDAndId(accountID,clientID);
        if (account.isPresent() && account.get().isWithdrawAllowed()) {
            return account.get();
        } else if(!(account.isPresent())) {
            throw new Exception("Account Not Founded 123");
        }else
            throw new Exception("Account Fixed");

    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.findAllAccountsById(clientID);
    }

    @Override
    public List<Account> getClientAccountByType(String clientID, AccountType accountType) {
        return null;
    }

    @Transactional
    @Override
    public boolean deleteAccountById(String accountID) {
        int deletedCount = accountDAO.deleteByClientID(accountID);
        return deletedCount > 0;

    }


}
