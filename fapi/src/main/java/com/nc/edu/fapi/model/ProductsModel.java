package com.nc.edu.fapi.model;


import java.util.Objects;


public class ProductsModel {
    private int idProduct;
    private String name;
    private String monthlyPrice;

    public ProductsModel() {
    }

    public ProductsModel(int idProduct, String monthlyPrice, String name) {
        this.idProduct = idProduct;
        this.name = name;

        this.monthlyPrice = monthlyPrice;


    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(String monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }
}


