package com.amitraj.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amitraj.currencyconversionservice.bean.CurrencyConversion;
import com.amitraj.currencyconversionservice.currency_exchange_proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	

	@GetMapping("/currency-conversion/from/{foreigncurrency}/to/{indiancurrency}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyCalculation(
			@PathVariable String foreigncurrency,
			@PathVariable String indiancurrency, 
			@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("foreigncurrency", foreigncurrency);
		uriVariables.put("indiancurrency", indiancurrency);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{foreigncurrency}/to/{indiancurrency}",
				      CurrencyConversion.class,uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		
	
		return new CurrencyConversion(currencyConversion.getId(),
				                      foreigncurrency,
				                      indiancurrency,
				                      currencyConversion.getConversionmultiple(),
				                      currencyConversion.getEnvironment()+" using restTemplate",
				                      quantity,
				                      quantity.multiply(currencyConversion.getConversionmultiple()));
	}
	
	@GetMapping("/currency-conversion-feign/from/{foreigncurrency}/to/{indiancurrency}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyCalculationFeign(
			@PathVariable String foreigncurrency,
			@PathVariable String indiancurrency, 
			@PathVariable BigDecimal quantity) {
		

		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(foreigncurrency, indiancurrency);
		
		
	
		return new CurrencyConversion(currencyConversion.getId(),
				                      foreigncurrency,
				                      indiancurrency,
				                      currencyConversion.getConversionmultiple(),
				                      currencyConversion.getEnvironment()+" feign",
				                      quantity,
				                      quantity.multiply(currencyConversion.getConversionmultiple()));
	}
}
