package com.example.solidbank2.dao;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountDAO extends CrudRepository<Account,Long> {
    List<Account>findAllAccountsById(String id);
    Account findAccountByClientIDAndId(String clientID,String accountID);



}
