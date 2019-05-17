package com.nc.edu.fapi.model;

import java.util.Objects;


public class WalletModel {
    private int idWallet;
    private Integer amountOfMoney;
    private Long walletNumber;
    private String expirationDate;


    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public Long getWalletNumber() {
        return walletNumber;
    }

    public void setWalletNumber(Long walletNumber) {
        this.walletNumber = walletNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }


    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletModel wallet = (WalletModel) o;
        return idWallet == wallet.idWallet &&
                Objects.equals(amountOfMoney, wallet.amountOfMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWallet, amountOfMoney);
    }
}
