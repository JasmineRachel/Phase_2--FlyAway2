package com.phase2.FlyAway.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phase2.FlyAway.model.Airline;
import com.phase2.FlyAway.service.AirlineService;

@RestController
public class AirlineController {
	
	@Autowired
	AirlineService airlineService;
	
	
	@GetMapping("/airline")
	public List<Airline> getAirlines(){
		return airlineService.getAirlines();
	}

}
