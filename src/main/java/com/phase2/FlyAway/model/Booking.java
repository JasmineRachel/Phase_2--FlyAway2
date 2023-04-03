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
public class Booking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	//make this User one to one
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
    private User customerId;
	// make this Flight one to one
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="flight_id")
    private Flight flightId;
	
	@Column(name="total_travelers")
	private int totalTravelers;
	@Column(name="total_price")
	private double totalPrice;

	public Booking() {
		
	}
	
	public Booking(User customerId, Flight flightId, int totalTravelers, double totalPrice) {
		super();
		this.customerId = customerId;
		this.flightId = flightId;
		this.totalTravelers = totalTravelers;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}

	public Flight getFlightId() {
		return flightId;
	}

	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}

	public int getTotalTravelers() {
		return totalTravelers;
	}

	public void setTotalTravelers(int totalTravelers) {
		this.totalTravelers = totalTravelers;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	


}
