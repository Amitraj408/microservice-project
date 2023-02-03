package com.amitraj.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

	@Id
	private Long id;
	private String foreigncurrency;
	private String indiancurrency;
	private BigDecimal conversionmultiple;
	private String environment;

	public ExchangeValue() {

	}

	public ExchangeValue(Long id, String foreigncurrency, String indiancurrency, BigDecimal conversionmultiple) {
		super();
		this.id = id;
		this.foreigncurrency = foreigncurrency;
		this.indiancurrency = indiancurrency;
		this.conversionmultiple = conversionmultiple;
		
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

	
	

}
