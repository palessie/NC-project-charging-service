package com.nc.edu.be.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transactions {
    private int idTransaction;
    private float money;
    private Wallet wallet;
    private String date;
    private String action;
    private String title;

    public Transactions(Wallet wallet, String action, float money, String title) {
        this.wallet = wallet;
        this.action = action;
        this.money = money;
        this.title = title;
    }

    public Transactions() {
    }

    @Id
    @Column(name = "id_transaction")
    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "money")
    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @ManyToOne
    @JoinColumn(name = "id_wallet", referencedColumnName = "id_wallet", nullable = false)
    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return getIdTransaction() == that.getIdTransaction() &&
                Objects.equals(getMoney(), that.getMoney()) &&
                Objects.equals(getWallet(), that.getWallet()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTransaction(), getMoney(), getWallet(), getDate());
    }
}
