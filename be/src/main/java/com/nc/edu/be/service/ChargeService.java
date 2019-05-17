package com.nc.edu.be.service;

public interface ChargeService {
    void scheduledCharge();
    void loadSubscriptions();
    void decreaseAmount();
    void decreaseDays();
    void checkSubscription();
    void saveDecreaseTransaction();
    void saveIncreaseTransaction(float cost, String title);
}
