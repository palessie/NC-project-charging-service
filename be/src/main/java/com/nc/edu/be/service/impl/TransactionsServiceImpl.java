package com.nc.edu.be.service.impl;

import com.nc.edu.be.entities.Transactions;
import com.nc.edu.be.service.TransactionsService;
import com.nc.edu.be.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class TransactionsServiceImpl implements TransactionsService {

    private TransactionsRepository repository;

    @Autowired
    public TransactionsServiceImpl(TransactionsRepository repository) { this.repository = repository; }

    @Override
    public Transactions saveTransaction(Transactions transaction) {
        return repository.save(transaction);
    }

    @Override
    public Optional<Transactions> getTransactionById(Integer idTransaction) {
        return repository.findById(idTransaction);
    }

    @Override
    public Iterable<Transactions> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public void deleteTransaction(Integer idTransaction) {
        repository.deleteById(idTransaction);
    }
}
