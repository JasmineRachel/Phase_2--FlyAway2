package com.phase2.FlyAway.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	//make this User one to one
	@Column(name="customer_id")
    private String customerId;
	// make this Flight one to one
	@Column(name="flight_id")
    private String flightId;
	
	public Booking() {
		
	}
	
	public Booking(int id, String customerId, String flightId) {
		super();
		this.customerId = customerId;
		this.flightId = flightId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerName(String customerId) {
		this.customerId = customerId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
}
