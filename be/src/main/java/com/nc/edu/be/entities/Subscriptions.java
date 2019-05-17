package com.nc.edu.be.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Subscriptions {
    private int idSubscription;
    private Date startDate;
    private Integer duration;
    private Date endDate;
    private float cost;
    private boolean status;
    private Users user;
    private Products product;

    @Id
    @Column(name = "id_subscription")
    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptions that = (Subscriptions) o;
        return idSubscription == that.idSubscription &&

                Objects.equals(startDate, that.startDate) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubscription, startDate, duration, endDate);
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false , insertable = false, updatable = false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users usersByIdUser) {
        this.user = usersByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false, insertable = false, updatable = false)
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products productsByIdProduct) {
        this.product = productsByIdProduct;
    }
}
