package com.example.solidbank2.dao;

import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.domain.account.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountDAO extends CrudRepository<Account,Long> {
    List<Account>findAllAccountsById(String id);
     Optional<Account> findAccountByClientIDAndId(String accountID, String  clientID);
  /*  @Modifying
    @Query("DELETE FROM account where clientID=:accountId")*/
    int deleteByClientID(String accountID);



}
