package com.nc.edu.fapi.controller;

import com.nc.edu.fapi.model.WalletModel;
import com.nc.edu.fapi.model.WalletOperationModel;
import com.nc.edu.fapi.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/fwallet")
public class WalletController {



    @Autowired
    WalletService walletService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<WalletModel>> getAllWallets() {
        return ResponseEntity.ok(walletService.getAllWallets());
    }

    @RequestMapping(value = "/{idWallet}", method = RequestMethod.GET)
    public ResponseEntity<WalletModel> getWalletById(@PathVariable Integer idWallet) {
        return ResponseEntity.ok(walletService.getWalletById(Integer.valueOf(idWallet)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WalletModel> saveWallet(@RequestBody WalletModel wallet) {
        if(wallet != null)
            return ResponseEntity.ok(walletService.saveWallet(wallet));
        else
            return null;
    }
    @RequestMapping(value = "/{idWallet}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable Integer idWallet) {
        walletService.deleteWallet(Integer.valueOf(idWallet));
    }

    @RequestMapping(value = "/replenish", method = RequestMethod.POST)
    public void setMoneyForWallet(@RequestBody WalletOperationModel purse) {
        walletService.replenishBalance(purse);
    }
}