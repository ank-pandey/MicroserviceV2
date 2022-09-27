package com.example.microservices.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionRate;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private String environment;
	
	public CurrencyConversion() {
		
	}
	
	public CurrencyConversion(Long id, String fromCurrency, String toCurrency, BigDecimal conversionRate,
			BigDecimal quantity, BigDecimal totalConvertedAmount, String environment) {
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalConvertedAmount;
		this.environment = environment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalConvertedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalConvertedAmount(BigDecimal totalConvertedAmount) {
		this.totalCalculatedAmount = totalConvertedAmount;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
}
