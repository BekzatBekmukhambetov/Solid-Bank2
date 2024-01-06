package com.example.solidbank2.domain.account;

public class SavingAccount extends AccountWithdraw{
    public SavingAccount(AccountType accountType, String id, String clientID, Double balance, boolean isWithdrawAllowed) {
        super(accountType, id, clientID, balance, isWithdrawAllowed);
    }
}
