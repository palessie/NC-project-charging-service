package com.nc.edu.be.controller;


import com.nc.edu.be.entities.Products;
import com.nc.edu.be.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
    public ResponseEntity<Products> getPostById(@PathVariable Integer idProduct) {
        Optional<Products> product = productsService.getProductById(idProduct);
        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Products> getAllProducts() {
      return productsService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Products savePost(@RequestBody Products product) {
        return productsService.saveProduct(product);
    }

    @RequestMapping(value = "/{idProduct}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable Integer idProduct) {
        productsService.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/page/{num}", method = RequestMethod.GET)
    public Iterable<Products> getProductsByPage(@PathVariable(name = "num") int num, @RequestParam("qt") int quantity) {
        Page pageContent = productsService.getProductsByPage(num, quantity);
        return pageContent.getContent();
    }

    @RequestMapping(value = "/total-pages", method = RequestMethod.GET)
    public int getTotalPages(@RequestParam("qt") int quantity) {
        Page pageContent = productsService.getProductsByPage(1, quantity);
        return pageContent.getTotalPages();
    }

}
