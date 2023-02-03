package com.amitraj.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrecncyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrecncyExchangeServiceApplication.class, args);
	}

}
