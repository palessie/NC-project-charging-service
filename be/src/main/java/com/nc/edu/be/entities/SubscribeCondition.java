package com.nc.edu.be.entities;

public class SubscribeCondition {
    private Double price;

    private int duration;

    public SubscribeCondition() {
    }

    public SubscribeCondition(double price,  int duration) {
        this.price = price;

        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
