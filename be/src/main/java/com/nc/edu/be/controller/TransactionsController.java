package com.nc.edu.be.controller;

import com.nc.edu.be.entities.Transactions;
import com.nc.edu.be.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Transactions> getPostById(@PathVariable(name = "id") Integer idTransaction) {
        Optional<Transactions> transaction = transactionsService.getTransactionById(idTransaction);
        if(transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Transactions> getAllProduct() { return transactionsService.getAllTransactions(); }

    @RequestMapping(method = RequestMethod.POST)
    public Transactions savePost(@RequestBody Transactions transaction) {
        return transactionsService.saveTransaction(transaction);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable(name = "id") Integer idTransaction) {
        transactionsService.deleteTransaction(idTransaction);
        return ResponseEntity.noContent().build();
    }
}
