package com.example.CoinPulse.facade;

import com.example.CoinPulse.client.CurrencyClient;
import com.example.CoinPulse.dto.CurrencyDTO;
import com.example.CoinPulse.model.CurrencyQueryLog;
import com.example.CoinPulse.repository.CurrencyRepository;
import com.example.CoinPulse.singleton.SystemTrackerSingleton;
import com.example.CoinPulse.strategy.AlertContext;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CurrencyFacade {

    private final CurrencyClient currencyClient;
    private final CurrencyRepository currencyRepository;
    private final AlertContext alertContext;

    public CurrencyFacade(CurrencyClient currencyClient, CurrencyRepository currencyRepository, AlertContext alertContext) {
        this.currencyClient = currencyClient;
        this.currencyRepository = currencyRepository;
        this.alertContext = alertContext;
    }

    public CurrencyDTO checkAndLogCurrency(String pair, String alertLevel) {
        SystemTrackerSingleton.getInstance().incrementRequests();

        Map<String, CurrencyDTO> response = currencyClient.getTicker(pair);

        String key = pair.replace("-", "");
        CurrencyDTO data = response.get(key);

        if (data != null) {
            currencyRepository.save(new CurrencyQueryLog(pair, data.bid()));
            double currentPrice = Double.parseDouble(data.bid());
            alertContext.execute(alertLevel, data.name(), currentPrice);
        }

        return data;
    }
}