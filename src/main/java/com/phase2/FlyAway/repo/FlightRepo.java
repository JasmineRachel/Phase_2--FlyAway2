package com.phase2.FlyAway.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase2.FlyAway.model.Flight;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Integer> {

}
