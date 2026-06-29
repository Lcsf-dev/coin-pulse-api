package com.example.CoinPulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoinPulseApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoinPulseApplication.class, args);
	}
}