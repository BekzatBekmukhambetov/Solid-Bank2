package com.example.solidbank2.domain.account;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, String id, String clientID, Double balance, boolean isWithdrawAllowed) {
        super(accountType, id, clientID, balance, isWithdrawAllowed);
    }
}
