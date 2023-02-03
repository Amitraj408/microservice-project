package com.amitraj.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitraj.limitsservice.bean.LimitConfiguration;


@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private LimitConfiguration limits;
	
	@GetMapping("/limits")
	public LimitConfiguration returnLimits() {
		
		return new LimitConfiguration(limits.getMaximum(),limits.getMinimum());
		
	}

}
