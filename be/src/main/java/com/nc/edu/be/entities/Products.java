package com.nc.edu.be.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Products {
    private int idProduct;
    private String name;
    private float monthlyPrice;
    private String description;

    @Id
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "monthly_price")
    public float getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(float monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", monthlyPrice='" + monthlyPrice + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
