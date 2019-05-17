package com.nc.edu.fapi.model;

public class SubscribeConditionModel {
    private Double price;
    private Double discount;
    private int duration;

    public SubscribeConditionModel() {
    }

    public SubscribeConditionModel(Double price, Double discount, int duration) {
        this.price = price;
        this.discount = discount;
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
