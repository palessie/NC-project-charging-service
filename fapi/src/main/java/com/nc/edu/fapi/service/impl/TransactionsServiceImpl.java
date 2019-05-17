package com.nc.edu.fapi.service.impl;

import com.nc.edu.fapi.model.TransactionsModel;
import com.nc.edu.fapi.service.TransactionsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public TransactionsModel getTransactionById(Integer idTransaction)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/transactions/" + idTransaction, TransactionsModel.class);
    }
    @Override
    public Iterable<TransactionsModel> getAllTransactions()
    {
        RestTemplate restTemplate = new RestTemplate();
        TransactionsModel[] transactionsModelResponse = restTemplate.getForObject(backendServerUrl + "/api/transactions/", TransactionsModel[].class);
        return transactionsModelResponse == null ? Collections.emptyList() : Arrays.asList(transactionsModelResponse);
    }
    @Override
    public void deleteTransaction(Integer idTransaction) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/transactions/" + idTransaction);
    }
    @Override
    public TransactionsModel saveTransaction(TransactionsModel transaction){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.postForEntity(backendServerUrl + "/api/transactions", transaction, TransactionsModel.class).getBody();
    }
}
