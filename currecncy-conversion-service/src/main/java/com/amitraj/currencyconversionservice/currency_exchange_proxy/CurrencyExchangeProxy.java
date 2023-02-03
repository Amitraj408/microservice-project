package com.amitraj.currencyconversionservice.currency_exchange_proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amitraj.currencyconversionservice.bean.CurrencyConversion;



//@FeignClient(name="currency-exchange",url="localhost:8000")
//load balancing just removing url in the above step
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	

	@GetMapping("/currency-exchange/{foreigncurrency}/to/{indiancurrency}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String foreigncurrency,@PathVariable String indiancurrency);

	

}
