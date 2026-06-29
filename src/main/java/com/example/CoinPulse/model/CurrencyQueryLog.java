package com.example.CoinPulse.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_currency_history")
public class CurrencyQueryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyPair;
    private String price;
    private LocalDateTime timestamp;

    public CurrencyQueryLog() {}

    public CurrencyQueryLog(String currencyPair, String price) {
        this.currencyPair = currencyPair;
        this.price = price;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getCurrencyPair() { return currencyPair; }
    public String getPrice() { return price; }
    public LocalDateTime getTimestamp() { return timestamp; }
}