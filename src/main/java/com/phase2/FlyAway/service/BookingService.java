package com.phase2.FlyAway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase2.FlyAway.model.Booking;
import com.phase2.FlyAway.repo.BookingRepo;

@Service
public class BookingService {
	@Autowired
	BookingRepo bookingRepo;
	
	public Booking getBookingById(int id) {
		return bookingRepo.findById(id).get();
	}
	
	public List<Booking> getAllBookings(){
		List<Booking> bookings = new ArrayList<Booking>();
		bookingRepo.findAll().forEach(booking -> bookings.add(booking));
		return bookings;
	}
	
	public void createBooking(Booking booking) {
		//this is how i would like the booking creation to go...
		//TODO: amend the booking model and add join types so that this logic works
		//Flight flight = flightService.getflightById(flightId)
		// User customer = userService.getUserById(customerId)
		//Booking booking = new Booking(flight, customer, totalBookingPrice)
		bookingRepo.save(booking);
	}
	
	public void deleteBooking(Integer id) {
		bookingRepo.deleteById(id);
	}
}
