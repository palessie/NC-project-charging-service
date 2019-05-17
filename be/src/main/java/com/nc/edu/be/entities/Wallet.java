package com.nc.edu.be.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Wallet {
    private int idWallet;
    private float amountOfMoney;
    private Long walletNumber;
    private String expirationDate;

    @Id
    @Column(name = "id_wallet")
    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Column(name = "wallet_number")
    public Long getWalletNumber() {
        return walletNumber;
    }

    public void setWalletNumber(Long walletNumber) {
        this.walletNumber = walletNumber;
    }
    @Column(name = "expiration_date")
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "amount_of_money")
    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return idWallet == wallet.idWallet &&
                Objects.equals(amountOfMoney, wallet.amountOfMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWallet, amountOfMoney);
    }
}
