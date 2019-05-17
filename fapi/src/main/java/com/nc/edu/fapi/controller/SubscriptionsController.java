package com.nc.edu.fapi.controller;


import com.nc.edu.fapi.model.SubscribeConditionModel;
import com.nc.edu.fapi.model.SubscriptionChangeModel;
import com.nc.edu.fapi.model.SubscriptionsModel;
import com.nc.edu.fapi.service.SubscriptionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/fsubscriptions")
public class SubscriptionsController {
    @Autowired
    SubscriptionsService subscriptionsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<SubscriptionsModel>> getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionsService.getAllSubscriptions());
    }

    @RequestMapping(value = "/{idSubscription}", method = RequestMethod.GET)
    public ResponseEntity<SubscriptionsModel> getSubscriptionById(@PathVariable Integer idSubscription) {
        return ResponseEntity.ok(subscriptionsService.getSubscriptionById(Integer.valueOf(idSubscription)));
    }

  /*  @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubscriptionsModel> saveSubscription(@RequestBody SubscriptionsModel subscription) {
        if(subscription != null)
            return ResponseEntity.ok(subscriptionsService.saveSubscription(subscription));
        else
            return null;
    }*/
    @RequestMapping(value = "/{idSubscription}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable Integer idSubscription) {
        subscriptionsService.deleteSubscription(Integer.valueOf(idSubscription));
    }
    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    public ResponseEntity<SubscribeConditionModel> computePrice(@RequestBody SubscribeConditionModel condition) {
        if(condition != null) {
            return ResponseEntity.ok(subscriptionsService.computePrice(condition));
        }
        return null;
    }

    @RequestMapping(value = "/extend", method = RequestMethod.POST)
    public void extendSubscription(@RequestBody SubscriptionChangeModel sub) {
        if(sub != null) {
            subscriptionsService.extendSubscription(sub);
        }
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public void chargeMoney() {
        subscriptionsService.chargeMoney();
    }
}
