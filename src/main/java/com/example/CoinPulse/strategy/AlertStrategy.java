package com.example.CoinPulse.strategy;

public interface AlertStrategy {
    void processAlert(String coin, double price);
    String getAlertLevel();
}