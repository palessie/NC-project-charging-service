package com.nc.edu.fapi.service.impl;

import com.nc.edu.fapi.model.StringResponseModel;
import com.nc.edu.fapi.model.SubscriptionsModel;
import com.nc.edu.fapi.service.SubscriptionsService;
import com.nc.edu.fapi.model.SubscribeConditionModel;
import com.nc.edu.fapi.model.SubscriptionChangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class SubscriptionsServiceImpl implements SubscriptionsService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    SubscriptionsService subscriptionsService;
    @Override
    public SubscriptionsModel getSubscriptionById(Integer idSubscription)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/subscriptions/" + idSubscription, SubscriptionsModel.class);
    }
    @Override
    public Iterable<SubscriptionsModel> getAllSubscriptions()
    {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionsModel[] subscriptionsModelResponse = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/", SubscriptionsModel[].class);
        return subscriptionsModelResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionsModelResponse);
    }
    @Override
    public void deleteSubscription(Integer idSubscription) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscriptions/" + idSubscription);
    }
   // @Override
 /*   public StringResponseModel saveSubscription(SubscriptionsModel sub){
        RestTemplate restTemplate = new RestTemplate();
        if(sub != null) {
            List<SubscriptionsModel> subscriptions = subscriptionsService.getSubscriptionsByLogin(sub.getUser().getLogin());
            List<String> posts = new ArrayList<>();

            for(SubscriptionsModel subscription: subscriptions) {
                posts.add(subscription.getProduct().getName());
                System.out.println("Post: " + subscription.getProduct().getName());
            }

            if(!posts.contains(sub.getProduct().getName())) {
                SubscriptionsModel tempSub = restTemplate.postForEntity(backendServerUrl + "api/subscriptions", sub, SubscriptionsModel.class).getBody();
                if(tempSub == null)
                    return new StringResponseModel("Not enough money");

                return new StringResponseModel("Successful");
            }
            else
                return new StringResponseModel("Already subscribed");
        }
        return new StringResponseModel("Empty subscription");
    }*/
    @Override
    public SubscribeConditionModel computePrice(SubscribeConditionModel condition) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "api/subscriptions/compute", condition, SubscribeConditionModel.class).getBody();
    }

    @Override
    public void extendSubscription(SubscriptionChangeModel sub) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "api/subscriptions/extend", sub, SubscriptionChangeModel.class).getBody();
    }

    @Override
    public void chargeMoney() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "api/subscriptions/charge", null , void.class);
    }
}
