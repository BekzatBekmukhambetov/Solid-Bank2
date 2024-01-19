package com.example.solidbank2.domain.account;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;


@Data
@AllArgsConstructor
@Entity
public class Account {
    AccountType accountType;
    String id ;
    @Id
    String clientID;
    Double balance;
    boolean isWithdrawAllowed;

    public Account() {

    }
}
