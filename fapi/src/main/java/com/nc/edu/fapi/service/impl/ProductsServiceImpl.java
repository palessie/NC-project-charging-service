package com.nc.edu.fapi.service.impl;

import com.nc.edu.fapi.model.ProductsModel;
import com.nc.edu.fapi.service.ProductsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ProductsModel getProductById(Integer idProduct)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/products/" + idProduct, ProductsModel.class);
    }
    @Override
    public List<ProductsModel> getAllProducts()
    {
        RestTemplate restTemplate = new RestTemplate();
        ProductsModel[] productsModelResponse = restTemplate.getForObject(backendServerUrl + "/api/products/", ProductsModel[].class);
        return productsModelResponse == null ? Collections.emptyList() : Arrays.asList(productsModelResponse);
    }
    @Override
    public void deleteProduct(Integer idProduct) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/products/" + idProduct);
    }
    @Override
    public ProductsModel saveProduct(ProductsModel product){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.postForEntity(backendServerUrl + "/api/products", product, ProductsModel.class).getBody();
    }
    @Override
    public List<ProductsModel> getProductsByPage(int page, int quantity) {
        RestTemplate restTemplate = new RestTemplate();
        ProductsModel[] postViewModelResponse = restTemplate.getForObject(backendServerUrl + "api/products/page/" + page + "?qt=" + quantity, ProductsModel[].class);
        return postViewModelResponse == null ? Collections.emptyList() : Arrays.asList(postViewModelResponse);
    }

    @Override
    public int getTotalPages(int quantity) {
        RestTemplate restTemplate = new RestTemplate();
        int response = restTemplate.getForObject(backendServerUrl + "api/products/total-pages?qt=" + quantity, Integer.class);
        return response;
    }
}
