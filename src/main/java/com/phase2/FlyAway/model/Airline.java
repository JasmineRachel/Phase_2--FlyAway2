package com.phase2.FlyAway.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Airline {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
	
	@Column(name="airline_name")
    public String airlineName;
	
//	@JsonBackReference
	@OneToOne(mappedBy="airlineId")
//	@JoinTable(name="flight", joinColumns=@JoinColumn(name="airline_id"))
	private Flight flight;
	
	public Airline() {
		
	}
	public Airline(String airlineName) {
		super();
		this.airlineName = airlineName;
	}
	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	
}
