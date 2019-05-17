package com.nc.edu.be.entities;

public class WalletOperation {

    private Integer id;
    private float amount;

    public WalletOperation() {
    }

    public WalletOperation(Integer id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
