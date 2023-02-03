package com.amitraj.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long id;
	private String foreigncurrency;
	private String indiancurrency;
	private BigDecimal conversionmultiple;
	private String environment;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;

	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversion(Long id, String foreigncurrency, String indiancurrency, BigDecimal conversionmultiple,
			String environment, BigDecimal quantity, BigDecimal totalCalculatedAmount) {
		super();
		this.id = id;
		this.foreigncurrency = foreigncurrency;
		this.indiancurrency = indiancurrency;
		this.conversionmultiple = conversionmultiple;
		this.environment = environment;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForeigncurrency() {
		return foreigncurrency;
	}

	public void setForeigncurrency(String foreigncurrency) {
		this.foreigncurrency = foreigncurrency;
	}

	public String getIndiancurrency() {
		return indiancurrency;
	}

	public void setIndiancurrency(String indiancurrency) {
		this.indiancurrency = indiancurrency;
	}

	public BigDecimal getConversionmultiple() {
		return conversionmultiple;
	}

	public void setConversionmultiple(BigDecimal conversionmultiple) {
		this.conversionmultiple = conversionmultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

}
