package com.nc.edu.be.service;

import com.nc.edu.be.entities.Products;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductsService {
    Products saveProduct(Products product);
    Optional<Products> getProductById(Integer idProduct);
    Iterable<Products> getAllProducts();
    void deleteProduct(Integer idProducts);
    Page<Products> getProductsByPage(int page, int quantity);

}
