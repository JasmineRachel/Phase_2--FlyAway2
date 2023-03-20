package com.phase2.FlyAway.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase2.FlyAway.model.Airline;
import com.phase2.FlyAway.service.AirlineService;

@RestController
public class AirlineController {
	
	@Autowired
	AirlineService airlineService;
	
	
	@GetMapping("/airlines")
	public List<Airline> getAirlines(){
		return airlineService.getAirlines();
	}
	
	@GetMapping("/airlines/{id}")
	public Airline getAirlineById(@PathVariable(value="id")int id){
		return airlineService.getAirlineById(id);
		
	}
	
	@PostMapping("add_airline")
	public int createAirline(@RequestBody Airline airline) {
		airlineService.createAirline(airline);
		return airline.getId();
	}

}
