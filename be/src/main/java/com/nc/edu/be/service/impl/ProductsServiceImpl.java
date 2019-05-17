package com.nc.edu.be.service.impl;

import com.nc.edu.be.entities.Products;
import com.nc.edu.be.service.ProductsService;
import com.nc.edu.be.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
@Component
public class ProductsServiceImpl implements ProductsService{
    private ProductsRepository repository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository repository)
    {
        this.repository = repository;
    }
    @Override
    public Products saveProduct(Products product)
    {
        return repository.save(product);
    }
    @Override
    public Optional<Products> getProductById(Integer idProduct)
    {
        return repository.findById(idProduct);
    }
    @Override
    public Iterable<Products> getAllProducts()
    {
        return repository.findAll();
    }
    @Override
    public void deleteProduct(Integer idProducts){
        repository.deleteById(idProducts);
    }
    @Override
    public Page<Products> getProductsByPage(int page, int quantity) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = new PageRequest(page-1, quantity, sort);
        return repository.findAll(pageable);
    }
}
