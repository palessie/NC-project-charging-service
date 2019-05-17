package com.nc.edu.be.controller;

import com.nc.edu.be.entities.Users;
import com.nc.edu.be.entities.Wallet;
import com.nc.edu.be.service.UsersService;
import com.nc.edu.be.service.WalletService;
import com.nc.edu.be.entities.WalletOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private UsersService usersService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Wallet> getWalletById(@PathVariable(name = "id") Integer idWallet) {
        Optional<Wallet> wallet = walletService.getWalletById(idWallet);
        if (wallet.isPresent())
            return ResponseEntity.ok(wallet.get());
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Wallet saveWallet(@RequestBody Wallet wallet) {
        return walletService.saveWallet(wallet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Wallet> deleteWallet(@PathVariable(name = "id") Integer idWallet) {
        walletService.deleteWallet(idWallet);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/replenish", method = RequestMethod.POST)
    public void replenishBalance(@RequestBody WalletOperation purse) {
        walletService.replenishBalance(purse);
    }

    @RequestMapping(value = "/user/{idUser}/login/{login}")
    public Wallet getWalletByUserLogin(@PathVariable int idUser, @PathVariable String login){
        Optional<Users> user = usersService.getUserById(idUser);
        return walletService.getWalletByOwnerLogin(user.get(), login);
    }
}