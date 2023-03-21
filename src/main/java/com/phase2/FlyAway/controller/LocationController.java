package com.phase2.FlyAway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase2.FlyAway.model.Location;
import com.phase2.FlyAway.service.LocationService;

@RestController
public class LocationController {
	@Autowired
	LocationService locationService;
	
	@GetMapping("/locations")
	public List<Location> getAllLocations(){
		return locationService.getAllLocations();	
	}
	
	@GetMapping("/locations/{id}")
	public Location getLocationById(@PathVariable int id){
		return locationService.getLocationById(id);
	}
	
	@PostMapping("/add_location")
	public int createLocation(@RequestBody Location location) {
		locationService.createLocation(location);
		return location.getId();
	}

}
