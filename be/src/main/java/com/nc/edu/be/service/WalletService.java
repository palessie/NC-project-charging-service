package com.nc.edu.be.service;

import com.nc.edu.be.entities.Users;
import com.nc.edu.be.entities.Wallet;
import com.nc.edu.be.entities.WalletOperation;
import java.util.Optional;

public interface WalletService {
    Wallet saveWallet(Wallet wallet);
    Optional<Wallet>  getWalletById(Integer idWallet);
    Iterable<Wallet> getAllWallets();
    void deleteWallet(Integer idWallet);
    void replenishBalance(WalletOperation purse);
    Wallet getWalletByOwnerLogin(Users user, String login);
}
