package com.example.CoinPulse.controller;

import com.example.CoinPulse.dto.CurrencyDTO;
import com.example.CoinPulse.facade.CurrencyFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/currencies")
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    public CurrencyController(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    @GetMapping("/{pair}")
    public ResponseEntity<CurrencyDTO> getCurrency(
            @PathVariable String pair,
            @RequestParam(defaultValue = "NORMAL") String level) {

        CurrencyDTO result = currencyFacade.checkAndLogCurrency(pair, level);
        return ResponseEntity.ok(result);
    }
}