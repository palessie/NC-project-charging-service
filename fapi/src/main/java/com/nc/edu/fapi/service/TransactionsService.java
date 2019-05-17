package com.nc.edu.fapi.service;

import com.nc.edu.fapi.model.TransactionsModel;

import java.util.Optional;

public interface TransactionsService {
    TransactionsModel saveTransaction(TransactionsModel transaction);
    TransactionsModel getTransactionById(Integer idTransaction);
    Iterable<TransactionsModel> getAllTransactions();
    void deleteTransaction(Integer idTransaction);
}
