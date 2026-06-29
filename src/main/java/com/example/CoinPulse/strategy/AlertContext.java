package com.example.CoinPulse.strategy;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AlertContext {
    private final Map<String, AlertStrategy> strategies;

    public AlertContext(List<AlertStrategy> alertStrategies) {
        this.strategies = alertStrategies.stream()
                .collect(Collectors.toMap(AlertStrategy::getAlertLevel, s -> s));
    }

    public void execute(String level, String coin, double price) {
        strategies.getOrDefault(level.toUpperCase(), strategies.get("NORMAL"))
                .processAlert(coin, price);
    }
}