package com.nc.edu.be.service;

import com.nc.edu.be.entities.Subscriptions;
import com.nc.edu.be.entities.SubscriptionChange;
import com.nc.edu.be.entities.SubscribeCondition;
import java.util.Optional;

public interface SubscriptionsService {

    Subscriptions saveSubscription(Subscriptions subscription);
    Optional<Subscriptions> getSubscriptionById(Integer idSubscription);
    Iterable<Subscriptions> getAllSubscriptions();
    void deleteSubscription(Integer idSubscription);
    void extendDuration(SubscriptionChange sub);
    SubscribeCondition computePrice(SubscribeCondition condition);
}
