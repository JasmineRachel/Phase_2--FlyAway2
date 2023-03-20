package com.phase2.FlyAway.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase2.FlyAway.model.Airline;
import com.phase2.FlyAway.repo.AirlineRepo;

@Service
public class AirlineService {

	
	@Autowired
	AirlineRepo airlineRepo;
	
	public Airline getAirlineById(Integer id) {
		return airlineRepo.findById(id).get();
	}
	
	public List<Airline> getAirlines(){
		List<Airline> airlines = new ArrayList<Airline>();
		airlineRepo.findAll().forEach(airline -> airlines.add(airline));
		return airlines;
	}
	
	public void createAirline(Airline airline) {
	
		airlineRepo.save(airline);
	}
	
	public void deleteAirline(Integer id) {
		airlineRepo.deleteById(id);
	}
}
