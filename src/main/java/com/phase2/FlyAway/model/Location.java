package com.phase2.FlyAway.model;

//import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
	
	@Column(name="location_name")
    public String locationName;
	
//	@JsonBackReference
    @OneToOne(mappedBy="destination")
    private Flight flight;
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Location() {
		
	}
	public Location(String locationName) {
		this.locationName = locationName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
    
    
    
}
