package com.example.solidbank2.dao;


import com.example.solidbank2.domain.Transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction,Long>{
    List<Transaction> findAllByClientID(String accountID);
}
