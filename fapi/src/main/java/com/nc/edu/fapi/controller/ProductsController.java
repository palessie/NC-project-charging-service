package com.nc.edu.fapi.controller;


import com.nc.edu.fapi.model.ProductsModel;
import com.nc.edu.fapi.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/fproducts")
public class ProductsController {

    ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ProductsModel>> getAllProducts() {
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
    public ResponseEntity<ProductsModel> getProductById(@PathVariable(name="idProduct") Integer idProduct) {
        return ResponseEntity.ok(productsService.getProductById(Integer.valueOf(idProduct)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductsModel> saveProduct(@RequestBody ProductsModel product) {
        if(product != null)
            return ResponseEntity.ok(productsService.saveProduct(product));
        else
            return null;
    }
    @RequestMapping(value = "/{idProduct}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name="idProduct") Integer idProduct) {
        productsService.deleteProduct(Integer.valueOf(idProduct));
    }

    @RequestMapping(value = "/page/{num}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductsModel>> getProductsByPage(@PathVariable(name = "num") int num, @RequestParam("qt") int quantity) {
        return ResponseEntity.ok(productsService.getProductsByPage(num, quantity));
    }

    @RequestMapping(value = "/total-pages", method = RequestMethod.GET)
    public int getTotalPages(@RequestParam("qt") int quantity) {
        return productsService.getTotalPages(quantity);
    }
}
