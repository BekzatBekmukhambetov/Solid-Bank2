package com.example.solidbank2.domain.account;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String id, String clientID, Double balance, boolean isWithdrawAllowed) {
        super(accountType, id, clientID, balance, isWithdrawAllowed);
    }
}
