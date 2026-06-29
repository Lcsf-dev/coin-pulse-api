package com.example.CoinPulse.strategy;

import org.springframework.stereotype.Component;

@Component
public class CriticalAlertStrategy implements AlertStrategy {
    @Override
    public void processAlert(String coin, double price) {
        System.out.println("🚨 ALERTA CRÍTICO: " + coin + " atingiu o valor de " + price + "!");
    }

    @Override
    public String getAlertLevel() { return "HIGH"; }
}