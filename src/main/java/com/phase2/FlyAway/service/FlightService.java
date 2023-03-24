package com.phase2.FlyAway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase2.FlyAway.model.Airline;
import com.phase2.FlyAway.model.Flight;
import com.phase2.FlyAway.model.Location;
import com.phase2.FlyAway.repo.FlightRepo;

@Service
public class FlightService {
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	AirlineService airlineService;
	@Autowired
	LocationService locationService;
	
	public Flight getFlightById(int id) {
		return flightRepo.findById(id).get();
	}
	
	public List<Flight> getAllFlights(){
		List<Flight> flights = new ArrayList<Flight>();
		flightRepo.findAll().forEach(flight -> flights.add(flight));
		return flights;
	}
	
	public void createFlight() {
		Location destination = locationService.getLocationById(2);
		Airline airlineId = airlineService.getAirlineById(1);
		Flight flight1 = new Flight(destination, "03-08-2023", 200.00, airlineId);
		flightRepo.save(flight1);
	}
	
	public void deleteFlight(int id) {
		flightRepo.deleteById(id);
	}
}
