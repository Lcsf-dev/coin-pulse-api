package com.example.CoinPulse.repository;

import com.example.CoinPulse.model.CurrencyQueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyQueryLog, Long> {}