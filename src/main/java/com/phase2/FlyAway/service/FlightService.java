package com.phase2.FlyAway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase2.FlyAway.model.Flight;
import com.phase2.FlyAway.repo.FlightRepo;

@Service
public class FlightService {
	@Autowired
	FlightRepo flightRepo;
	
	public Flight getFlightById(int id) {
		return flightRepo.findById(id).get();
	}
	
	public List<Flight> getAllFlights(){
		List<Flight> flights = new ArrayList<Flight>();
		flightRepo.findAll().forEach(flight -> flights.add(flight));
		return flights;
	}
	
	public void createFlight(Flight flight) {
	
		flightRepo.save(flight);
	}
	
	public void deleteFlight(int id) {
		flightRepo.deleteById(id);
	}
}
