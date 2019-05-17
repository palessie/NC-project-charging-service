package com.nc.edu.be.repository;

import com.nc.edu.be.entities.Wallet;
import com.nc.edu.be.entities.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Integer>{
    @Modifying
    @Transactional
    @Query("update Wallet purse set purse.amountOfMoney = purse.amountOfMoney + :amount where purse.idWallet = :id")
    void replenishBalance(@Param("amount") float amount, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("update Wallet purse set purse.amountOfMoney = purse.amountOfMoney - :amount where purse.idWallet = :id")
    void chargeMoney(@Param("amount") float amount, @Param("id") Integer id);

    Wallet getWalletByUserLogin(Users user,String login);
}
