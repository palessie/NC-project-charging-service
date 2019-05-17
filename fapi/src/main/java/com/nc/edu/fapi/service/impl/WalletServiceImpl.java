package com.nc.edu.fapi.service.impl;


import com.nc.edu.fapi.model.WalletModel;
import com.nc.edu.fapi.model.WalletOperationModel;
import com.nc.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class WalletServiceImpl implements WalletService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public WalletModel getWalletById(Integer idWallet)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/wallet/" + idWallet, WalletModel.class);
    }
    @Override
    public Iterable<WalletModel> getAllWallets()
    {
        RestTemplate restTemplate = new RestTemplate();
        WalletModel[] walletsModelResponse = restTemplate.getForObject(backendServerUrl + "/api/wallet/", WalletModel[].class);
        return walletsModelResponse == null ? Collections.emptyList() : Arrays.asList(walletsModelResponse);
    }
    @Override
    public void deleteWallet(Integer idWallet) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/wallet/" + idWallet);
    }
    @Override
    public WalletModel saveWallet(WalletModel wallet){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.postForEntity(backendServerUrl + "/api/wallet", wallet, WalletModel.class).getBody();
    }
    @Override
    public void replenishBalance(WalletOperationModel purse) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/wallets/replenish", purse, WalletOperationModel.class);
    }

}
