package com.nc.edu.fapi.model;

public class WalletOperationModel {

    private Integer id;
    private float amount;

    public WalletOperationModel() {
    }

    public WalletOperationModel(Integer id, float amount) {
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
