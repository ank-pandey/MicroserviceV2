package com.example.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.bean.CurrencyExchange;
import com.example.microservices.repo.CurrencyExchangeRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository exchangeRepository;

	@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange retrieveCurrencyExchange(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency){
		
		log.info("retrieveCurrencyExchange called with {} to {}", fromCurrency, toCurrency);
		
		 CurrencyExchange exchange = exchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		 if(null == exchange) {
			 throw new RuntimeException("There is no currency exchange data present from  "
					 + fromCurrency + " currency to " + toCurrency + " currency" );
		 }
		 //CurrencyExchange exchange = new CurrencyExchange(1L, "USD", "INR", BigDecimal.valueOf(81));
		 exchange.setEnvironment(env.getProperty("local.server.port"));
		 return exchange;
	}
}
