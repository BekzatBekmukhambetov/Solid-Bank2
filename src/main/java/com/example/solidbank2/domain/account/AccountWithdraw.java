package com.example.solidbank2.domain.account;

public class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientID, Double balance, boolean isWithdrawAllowed) {
        super(accountType, id, clientID, balance, isWithdrawAllowed);
    }
}
