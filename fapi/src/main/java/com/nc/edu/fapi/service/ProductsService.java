package com.nc.edu.fapi.service;

import com.nc.edu.fapi.model.ProductsModel;

import java.util.List;

public interface ProductsService {
    ProductsModel saveProduct(ProductsModel product);
    ProductsModel getProductById(Integer idProduct);
    List<ProductsModel> getAllProducts();
    void deleteProduct(Integer idProducts);
    List<ProductsModel> getProductsByPage(int page, int quantity);
    int getTotalPages(int quantity);

}
