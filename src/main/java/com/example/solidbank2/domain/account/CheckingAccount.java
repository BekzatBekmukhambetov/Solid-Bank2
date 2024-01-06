package com.example.solidbank2.domain.account;

public class CheckingAccount extends  AccountWithdraw{
    public CheckingAccount(AccountType accountType, String id, String clientID, Double balance, boolean isWithdrawAllowed) {
        super(accountType, id, clientID, balance, isWithdrawAllowed);
    }
}
