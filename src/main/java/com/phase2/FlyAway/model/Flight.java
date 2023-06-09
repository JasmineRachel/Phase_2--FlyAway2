package com.phase2.FlyAway.model;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Flight {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="source")
    private String source;
	
//	@JsonManagedReference
//    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Location> sources = new ArrayList<>();
//	
//	@JsonManagedReference
//    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Location> destinations = new ArrayList<>();
	
	@Column(name="destination")
    private String destination;
	@Column(name="date")
    public String date;
	@Column(name="price")
    public double price;
	//one to one Arline
	@Column(name="airline_id")
    public int airlineId;
	// one flight can have many locations because source & destination? one to many?
	public Flight() {
		
	}
	public Flight(int id, String source, String destination, String date, double price, int airlineId) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.price = price;
		this.airlineId = airlineId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	
}
