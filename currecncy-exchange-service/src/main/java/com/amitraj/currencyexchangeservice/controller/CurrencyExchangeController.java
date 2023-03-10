package com.amitraj.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amitraj.currencyexchangeservice.bean.ExchangeValue;
import com.amitraj.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController

public class CurrencyExchangeController {
	

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/{foreigncurrency}/to/{indiancurrency}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String foreigncurrency,@PathVariable String indiancurrency) {

		ExchangeValue exchangeValue = repository.findByForeigncurrencyAndIndiancurrency(foreigncurrency, indiancurrency);
		if(exchangeValue==null) {
			throw new RuntimeException("unable to find data"+foreigncurrency+" "+indiancurrency);
		}

		String port = environment.getProperty("local.server.port");
		exchangeValue.setEnvironment(port);
		
		return exchangeValue;

	}

}
