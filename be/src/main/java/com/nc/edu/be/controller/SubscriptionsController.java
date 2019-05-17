package com.nc.edu.be.controller;


import com.nc.edu.be.entities.Subscriptions;
import com.nc.edu.be.service.SubscriptionsService;
import com.nc.edu.be.service.ChargeService;
import com.nc.edu.be.entities.SubscriptionChange;
import com.nc.edu.be.entities.SubscribeCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionsController {
    @Autowired
    private SubscriptionsService subscriptionsService;

    @Autowired
    ChargeService chargeService;

    @RequestMapping(value = "/{idSubscription}", method = RequestMethod.GET)
    public ResponseEntity<Subscriptions> getPostById(@PathVariable Integer idSubscription) {
        Optional<Subscriptions> subscription = subscriptionsService.getSubscriptionById(idSubscription);
        if(subscription.isPresent()) {
            return ResponseEntity.ok(subscription.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Subscriptions> getAllProduct() { return subscriptionsService.getAllSubscriptions(); }

    @RequestMapping(method = RequestMethod.POST)
    public Subscriptions savePost(@RequestBody Subscriptions subscription) {
        return subscriptionsService.saveSubscription(subscription);
    }

    @RequestMapping(value = "/{idSubscription}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable Integer idSubscription) {
        subscriptionsService.deleteSubscription(idSubscription);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    public SubscribeCondition computePrice(@RequestBody SubscribeCondition condition) {
        return subscriptionsService.computePrice(condition);
    }

    @RequestMapping(value = "/extend", method = RequestMethod.POST)
    public void extendDuration(@RequestBody SubscriptionChange sub) {
        subscriptionsService.extendDuration(sub);
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public void chargeMoney() {
        chargeService.scheduledCharge();
    }
}
