package com.amitraj.currencyexchangeservice.circuitbreaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api",fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name = "sample-api",fallbackMethod = "hardcodedResponse")
	public String sampleApi() {
		logger.info("sample api call received");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://8080/some-localhost", String.class);
		return entity.getBody();
	}
	public String hardcodedResponse(Exception ex) {
		return "fallback Resopnse";
	}

}
