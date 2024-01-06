package com.example.solidbank2.dao;

import com.example.solidbank2.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
