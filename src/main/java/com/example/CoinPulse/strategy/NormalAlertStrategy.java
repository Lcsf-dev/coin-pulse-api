package com.example.CoinPulse.strategy;

import org.springframework.stereotype.Component;

@Component
public class NormalAlertStrategy implements AlertStrategy {
    @Override
    public void processAlert(String coin, double price) {
        System.out.println("ℹ️ Relatório Diário: " + coin + " está cotado a " + price);
    }

    @Override
    public String getAlertLevel() { return "NORMAL"; }
}