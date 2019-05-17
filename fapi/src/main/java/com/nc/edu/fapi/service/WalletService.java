package com.nc.edu.fapi.service;

import com.nc.edu.fapi.model.WalletModel;
import com.nc.edu.fapi.model.WalletOperationModel;

import java.util.Optional;

public interface WalletService {
    WalletModel saveWallet(WalletModel wallet);
    WalletModel  getWalletById(Integer idWallet);
    Iterable<WalletModel> getAllWallets();
    void deleteWallet(Integer idWallet);
    void replenishBalance(WalletOperationModel purse);
}
