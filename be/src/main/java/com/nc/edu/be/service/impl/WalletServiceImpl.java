package com.nc.edu.be.service.impl;


import com.nc.edu.be.entities.Users;
import com.nc.edu.be.entities.Wallet;
import com.nc.edu.be.entities.WalletOperation;
import com.nc.edu.be.service.WalletService;
import com.nc.edu.be.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WalletServiceImpl implements WalletService {

    private WalletRepository repository;

    @Autowired
    public WalletServiceImpl(WalletRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Wallet saveWallet(Wallet wallet)
    {
        return repository.save(wallet);
    }

    @Override
    public Optional<Wallet> getWalletById(Integer idWallet)
    {
        return repository.findById(idWallet);
    }

    @Override
    public Iterable<Wallet> getAllWallets()
    {
        return repository.findAll();
    }

    @Override
    public void deleteWallet(Integer idWallet)
    {
        repository.deleteById(idWallet);
    }

    @Override
    public void replenishBalance(WalletOperation purse) {
        repository.replenishBalance(purse.getAmount(), purse.getId());
    }
    @Override
    public Wallet getWalletByOwnerLogin(Users user, String login){
        return repository.getWalletByUserLogin(user,login);
    }
}
