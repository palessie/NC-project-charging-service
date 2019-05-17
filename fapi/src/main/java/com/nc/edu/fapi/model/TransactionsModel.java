package com.nc.edu.fapi.model;

import java.util.Objects;


public class TransactionsModel {
    private int idTransaction;
    private String money;
    private int idWallet;
    private String date;
    private SubscriptionsModel subscription;



    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }


    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public SubscriptionsModel getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionsModel subscription) {
        this.subscription = subscription;
    }
    }

