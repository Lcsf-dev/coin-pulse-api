package com.example.CoinPulse.client;

import com.example.CoinPulse.dto.CurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "currencyClient", url = "https://economia.awesomeapi.com.br")
public interface CurrencyClient {

    @GetMapping("/last/{currencies}")
    Map<String, CurrencyDTO> getTicker(@PathVariable("currencies") String currencies);
}