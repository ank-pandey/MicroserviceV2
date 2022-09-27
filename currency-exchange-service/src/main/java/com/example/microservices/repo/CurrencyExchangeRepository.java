package com.example.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
