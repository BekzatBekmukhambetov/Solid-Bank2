package com.example.solidbank2.service.impl;

import com.example.solidbank2.dao.AccountDAO;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.service.AccountWithdrawService;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;


    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(Account account, double amount) throws Exception {

        if (amount >= 0) {
            double remainingBalance = account.getBalance() - amount;

            if (remainingBalance >= 0) {
                account.setBalance(remainingBalance);
                accountDAO.save(account);
                System.out.println(amount + " withdrawn from " + account.getClientID());
            } else {
                throw new Exception("Insufficient funds");
            }
        } else {
            throw new Exception("Incorrect Amount");
        }
    }
}
