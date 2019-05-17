package com.nc.edu.be.service.impl;

import com.nc.edu.be.entities.*;
import com.nc.edu.be.service.SubscriptionsService;
import com.nc.edu.be.repository.SubscriptionsRepository;
import com.nc.edu.be.entities.SubscribeCondition;
import com.nc.edu.be.entities.SubscriptionChange;
import com.nc.edu.be.repository.TransactionsRepository;
import com.nc.edu.be.repository.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Optional;
import java.time.LocalDateTime;

@Component
public class SubscriptionsServiceImpl implements SubscriptionsService {

    private SubscriptionsRepository repository;
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private WalletRepository walletRepository;


    @Autowired
    public SubscriptionsServiceImpl(SubscriptionsRepository repository) {
        this.repository = repository;
    }
    @Override
    public Subscriptions saveSubscription(Subscriptions subscription) {
        return this.repository.save(subscription);
    }

    @Override
    public Optional<Subscriptions> getSubscriptionById(Integer idSubscription) {
        return this.repository.findById(idSubscription);
    }

    @Override
    public Iterable<Subscriptions> getAllSubscriptions() {
        return this.repository.findAll();
    }

    @Override
    public void deleteSubscription(Integer idSubscription) {
        this.repository.deleteById(idSubscription);
    }


    private int convertDuration(int duration) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int currentMonth = Integer.parseInt(LocalDateTime.now().toString().split("-")[1]);
        int days = 0;

        int finalMonth = currentMonth + duration;

        if(finalMonth > 12) {
            finalMonth -= 12;
            for(int i=currentMonth; i<monthDays.length; i++) {
                days += monthDays[i-1];
            }

            for(int i=0; i<finalMonth; i++) {
                days += monthDays[i];
            }
        } else {
            for(int i=currentMonth; i<finalMonth; i++) {
                days += monthDays[i-1];
            }
        }

        return days;
    }
    @Override
    public SubscribeCondition computePrice(SubscribeCondition condition) {
        Double wholePrice = condition.getPrice() * condition.getDuration();
        condition.setPrice(wholePrice);
        condition.setPrice(fixedNum(condition.getPrice()));
        return condition;
    }
    private Double fixedNum(Double num) {
        int fix = num.toString().split("\\.")[1].length();
        String fixFormat;

        if(fix >= 2)
            fixFormat = ".##";
        else
            fixFormat = ".#";

        DecimalFormat df2 = new DecimalFormat(fixFormat);

        return Double.valueOf(df2.format(num));
    }
    @Override
    public void extendDuration(SubscriptionChange sub) {
        int oldDuration = repository.findById(sub.getId()).get().getDuration();

        int newDuration = this.convertDuration(sub.getDuration());

        float newCost = sub.getCost()/(oldDuration + newDuration);

        repository.changeCost(sub.getId(), newCost);
        repository.extendDuration(sub.getId(), newDuration);
    }

    private Transactions createTransaction(Subscriptions sub) {
        double tempCost = fixedNum(Double.valueOf(sub.getCost()));
        float cost = (float)tempCost;

        Transactions action = new Transactions();
        action.setAction("MINUS");
        action.setMoney(cost);
        action.setTitle(sub.getProduct().getName());
        action.setWallet(sub.getUser().getWallet());

        return action;
    }


}
