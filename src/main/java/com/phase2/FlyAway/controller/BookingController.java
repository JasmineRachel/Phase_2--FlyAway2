package com.phase2.FlyAway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase2.FlyAway.model.Booking;
import com.phase2.FlyAway.service.BookingService;

@RestController
@CrossOrigin
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/bookings/{id}")
	public Booking getBookingById(@PathVariable(value="id")int id){
		return bookingService.getBookingById(id);
		
	}
	
	@PostMapping(value = "create_booking", consumes = {"*/*"})
	public int createBooking(@RequestBody Booking booking) {
		bookingService.createBooking(booking);
		return booking.getId();
	}
}
