package com.example.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.bean.CurrencyConversion;
import com.example.microservices.feign.CurrencyExchangeProxy;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy exchangeProxy;
	
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion retrieveConvertedCurrency(@PathVariable String fromCurrency,
				@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromCurrency", fromCurrency);
		uriVariables.put("toCurrency", toCurrency);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}",
				CurrencyConversion.class, uriVariables);
		CurrencyConversion conversion = responseEntity.getBody();
		return new CurrencyConversion(conversion.getId(), 
				conversion.getFromCurrency(), conversion.getToCurrency(), 
				conversion.getConversionRate(), quantity,
				quantity.multiply(conversion.getConversionRate()), conversion.getEnvironment());
	}
	
	@GetMapping("/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion retrieveFeignConvertedCurrency(@PathVariable String fromCurrency,
				@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {
		CurrencyConversion conversion = exchangeProxy.retrieveCurrencyExchange(fromCurrency, toCurrency);
		return new CurrencyConversion(conversion.getId(), 
				conversion.getFromCurrency(), conversion.getToCurrency(), 
				conversion.getConversionRate(), quantity,
				quantity.multiply(conversion.getConversionRate()), conversion.getEnvironment());
	}
}
