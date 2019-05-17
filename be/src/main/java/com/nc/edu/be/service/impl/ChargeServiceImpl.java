package com.nc.edu.be.service.impl;

import com.nc.edu.be.entities.Subscriptions;
import com.nc.edu.be.entities.Transactions;
import com.nc.edu.be.entities.Wallet;
import com.nc.edu.be.repository.SubscriptionsRepository;
import com.nc.edu.be.repository.TransactionsRepository;
import com.nc.edu.be.service.ChargeService;
import com.nc.edu.be.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.nc.edu.be.repository.WalletRepository;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Component
public class ChargeServiceImpl implements ChargeService {

    private ArrayList<Subscriptions> subscriptions = new ArrayList<>();

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public void loadSubscriptions() {
        subscriptions.clear();
        Iterable<Subscriptions> iterableSubs = subscriptionsRepository.findAll();
        for(Subscriptions sub: iterableSubs) {
            subscriptions.add(sub);
        }

    }

    private boolean checkMoney(Subscriptions sub) {
        boolean status;
        System.out.println("Current money: " + sub.getUser().getWallet().getAmountOfMoney());
        if((sub.getUser().getWallet().getAmountOfMoney() - sub.getCost()) < 0 ) {
            status = false;
            subscriptionsRepository.falseStatus(sub.getIdSubscription());
        } else {
            status = true;
            subscriptionsRepository.trueStatus(sub.getIdSubscription());
        }

        return status;
    }

    @Override
    public void decreaseAmount() {

        for(Subscriptions sub: subscriptions) {
            if(checkMoney(sub)) {
                walletRepository.chargeMoney(fixedNum(sub.getCost()), sub.getUser().getWallet().getIdWallet());
                sub.getUser().getWallet().setAmountOfMoney(sub.getUser().getWallet().getAmountOfMoney() - fixedNum(sub.getCost()));
                walletRepository.replenishBalance(fixedNum(sub.getCost()), 1);
                subscriptionsRepository.decreaseDuration(sub.getIdSubscription());
                sub.setDuration(sub.getDuration() - 1);
                saveIncreaseTransaction(fixedNum(sub.getCost()), sub.getProduct().getName());
                System.out.println("Cost: " + sub.getCost());
                System.out.println("Money[" + sub.getUser().getWallet().getIdWallet() + "]: " + sub.getUser().getWallet().getAmountOfMoney());
            }
        }
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void scheduledCharge() {
        loadSubscriptions();
//        decreaseDays();
        checkSubscription();
        decreaseAmount();
        saveDecreaseTransaction();
    }

    @Override
    public void decreaseDays() {
        for(Subscriptions sub: subscriptions) {
            if(checkMoney(sub)) {
                subscriptionsRepository.decreaseDuration(sub.getIdSubscription());
                sub.setDuration(sub.getDuration() - 1);
            }
        }
    }

    @Override
    public void checkSubscription() {
        ArrayList<Subscriptions> toDelete = new ArrayList<>();

        for(Subscriptions sub: subscriptions) {
            if(sub.getDuration() >= 0) {
                System.out.println("Left days[" + sub.getIdSubscription() + "]: " + sub.getDuration());
            }
            else {
                toDelete.add(sub);
                subscriptionsRepository.deleteById(sub.getIdSubscription());
            }
        }

        for(Subscriptions deleteSub: toDelete) {
            subscriptions.remove(deleteSub);
        }
    }

    @Override
    public void saveDecreaseTransaction() {
        Transactions action;

        for(Subscriptions sub: subscriptions) {
            action = new Transactions(sub.getUser().getWallet(), "MINUS", fixedNum(sub.getCost()), sub.getProduct().getName());
            transactionsRepository.save(action);
        }
    }

    @Override
    public void saveIncreaseTransaction(float cost, String title) {
        Transactions action;
        action = new Transactions(walletRepository.findById(1).get(), "PLUS", cost, title);
        transactionsRepository.save(action);
    }

    private Float fixedNum(Float num) {
        int fix = num.toString().split("\\.")[1].length();
        String fixFormat;

        if(fix >= 2)
            fixFormat = ".##";
        else
            fixFormat = ".#";

        DecimalFormat df2 = new DecimalFormat(fixFormat);

        return Float.valueOf(df2.format(num));
    }
}
