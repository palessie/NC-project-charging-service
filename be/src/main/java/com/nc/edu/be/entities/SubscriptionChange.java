package com.nc.edu.be.entities;


public class SubscriptionChange {

    private Integer id;
    private int duration;
    private float cost;

    public SubscriptionChange() {
    }

    public SubscriptionChange(int duration, float cost) {
        this.duration = duration;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}

