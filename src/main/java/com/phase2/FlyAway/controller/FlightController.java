package com.phase2.FlyAway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase2.FlyAway.model.Airline;
import com.phase2.FlyAway.model.Flight;
import com.phase2.FlyAway.model.Location;
import com.phase2.FlyAway.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
//	@Autowired
//	Airline airline;
//	@Autowired
//	Location location;
	
	@GetMapping("/flights")
	public List<Flight> getAllFlights(Location location, Airline airline){
		flightService.createFlight();
		return flightService.getAllFlights();	
	}
	@GetMapping("/flights/{id}")
	public Flight getFlightById(@PathVariable int id){
		return flightService.getFlightById(id);
	}
	
//	@PostMapping("/add_flight")
//	public int createFlight(@RequestBody Flight flight) {
//		flightService.createFlight(flight);
//		return flight.getId();
//	}
}
