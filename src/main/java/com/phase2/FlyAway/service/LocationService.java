package com.phase2.FlyAway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase2.FlyAway.model.Location;
import com.phase2.FlyAway.repo.LocationRepo;

@Service
public class LocationService {
	@Autowired
	LocationRepo locationRepo;
	
	public Location getLocationById(int id) {
		return locationRepo.findById(id).get();
	}
	
	public List<Location> getAllLocations(){
		List<Location> locations = new ArrayList<Location>();
		locationRepo.findAll().forEach(location -> locations.add(location));
		return locations;
	}
	
	public void createLocation() {
		Location location1 = new Location("Barcelona");
		Location location2 = new Location("Paris");
		Location location3 = new Location("Amsterdam");
		locationRepo.save(location1);
		locationRepo.save(location2);
		locationRepo.save(location3);
	}
	
	public void deleteLocation(int id) {
		locationRepo.deleteById(id);
	}
}

