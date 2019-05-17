package com.nc.edu.fapi.controller;

import com.nc.edu.fapi.model.TransactionsModel;
import com.nc.edu.fapi.service.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/ftransactions")
public class TransactionsController {
    @Autowired
    TransactionsService transactionsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TransactionsModel>> getAllTransactions() {
        return ResponseEntity.ok(transactionsService.getAllTransactions());
    }

    @RequestMapping(value = "/{idTransaction}", method = RequestMethod.GET)
    public ResponseEntity<TransactionsModel> getTransactionById(@PathVariable Integer idTransaction) {
        return ResponseEntity.ok(transactionsService.getTransactionById(Integer.valueOf(idTransaction)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransactionsModel> saveTransaction(@RequestBody TransactionsModel transaction) {
        if(transaction != null)
            return ResponseEntity.ok(transactionsService.saveTransaction(transaction));
        else
            return null;
    }
    @RequestMapping(value = "/{idTransaction}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable Integer idTransaction) {
        transactionsService.deleteTransaction(Integer.valueOf(idTransaction));
    }
}
