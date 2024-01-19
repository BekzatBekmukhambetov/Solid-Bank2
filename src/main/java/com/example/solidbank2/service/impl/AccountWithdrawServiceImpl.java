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
    public void withdraw(Account account, double amount) {
       if(account == null) {
            System.out.println("Account its Fixed");
            return;
        }
        if(amount>=0){
            double test = account.getBalance()-amount;
            if(test>=0){
                account.setBalance(test);
                accountDAO.save(account);
                System.out.println(amount+" withdrawn from "+ account.getClientID());
            }else{
                System.out.println("Not enough money");
            }
        }else
        System.out.println("incorrect data");
    }
}
