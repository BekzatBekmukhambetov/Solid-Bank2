package com.example.solidbank2.service;

import com.example.solidbank2.domain.account.AccountType;
import org.springframework.stereotype.Service;


public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
