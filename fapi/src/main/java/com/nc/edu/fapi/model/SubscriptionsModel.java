package com.nc.edu.fapi.model;

import java.sql.Date;
import java.util.Objects;


public class SubscriptionsModel {
    private int idSubscription;
    private UsersModel user;
    private ProductsModel product;
    private Date startDate;
    private Integer duration;
    private Date endDate;



    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }


    public UsersModel getIdUser() {
        return user;
    }

    public void setIdUser(UsersModel user) {
        this.user = user;
    }


    public ProductsModel getProduct() {
        return product;
    }

    public void setProduct(ProductsModel product) {
        this.product = product;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    }

