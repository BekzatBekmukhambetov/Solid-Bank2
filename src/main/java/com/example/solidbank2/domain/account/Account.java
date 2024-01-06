package com.example.solidbank2.domain.account;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;


@Data
@AllArgsConstructor
public class Account {
    AccountType accountType;
    String id ;
    String clientID;
    Double balance;
    boolean isWithdrawAllowed;

}
