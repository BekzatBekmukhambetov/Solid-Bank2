package com.example.solidbank2.dao;

import com.example.solidbank2.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MemoryTransactionDAO implements TransactionDAO{
    List<Transaction>transactions;

    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
