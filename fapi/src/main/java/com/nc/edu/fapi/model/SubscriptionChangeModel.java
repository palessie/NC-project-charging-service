package com.nc.edu.fapi.model;


public class SubscriptionChangeModel {

    private Integer id;
    private int duration;


    public SubscriptionChangeModel() {
    }

    public SubscriptionChangeModel(int duration) {
        this.duration = duration;

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
}

