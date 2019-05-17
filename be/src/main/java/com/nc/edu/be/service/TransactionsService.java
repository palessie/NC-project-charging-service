package com.nc.edu.be.service;

import com.nc.edu.be.entities.Transactions;

import java.util.Optional;

public interface TransactionsService {
    Transactions saveTransaction(Transactions transaction);
    Optional<Transactions> getTransactionById(Integer idTransaction);
    Iterable<Transactions> getAllTransactions();
    void deleteTransaction(Integer idTransaction);
}
