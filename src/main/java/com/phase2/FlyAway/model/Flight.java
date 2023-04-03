package com.phase2.FlyAway.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Flight {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
	
//	@JsonManagedReference
//    @ManyToMany(mappedBy="flight")
//	@JoinColumn(name="source_id", nullable=false)
//	private Location source;
	
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="destination_id", nullable=false)
	private Location destination;
	
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="airline_id", nullable=false)
	private Airline airlineId;
	
	@Column(name="date")
    private String date;
	@Column(name="price")
    private double price;

	@OneToOne(mappedBy = "flightId")
	private Booking booking;
	
	public Flight() {
		
	}
	public Flight(Location destination, String date, double price, Airline airlineId) {
//		this.source = source;
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
	
//	public Location getSource() {
//		return source;
//	}
//	public void setSource(Location source) {
//		this.source = source;
//	}
	
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	
	public Airline getAirlineId() {
		return airlineId;
	}
	
	public void setAirlineId(Airline airlineId) {
		this.airlineId = airlineId;
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

	
}
