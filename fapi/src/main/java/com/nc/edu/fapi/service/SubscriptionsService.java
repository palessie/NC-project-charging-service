package com.nc.edu.fapi.service;

import com.nc.edu.fapi.model.StringResponseModel;
import com.nc.edu.fapi.model.SubscriptionsModel;
import com.nc.edu.fapi.model.SubscriptionChangeModel;
import com.nc.edu.fapi.model.SubscribeConditionModel;



import java.util.Optional;

public interface SubscriptionsService {

  //  StringResponseModel saveSubscription(SubscriptionsModel subscription);
    SubscriptionsModel getSubscriptionById(Integer idSubscription);
    Iterable<SubscriptionsModel> getAllSubscriptions();
    void deleteSubscription(Integer idSubscription);
    SubscribeConditionModel computePrice(SubscribeConditionModel condition);
    void extendSubscription(SubscriptionChangeModel sub);
    void chargeMoney();
}
