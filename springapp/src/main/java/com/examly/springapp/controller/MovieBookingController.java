package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IMovieBooking;
import com.examly.springapp.model.MovieBooking;

@RestController
public class MovieBookingController {

	@Autowired
	IMovieBooking iMovieBooking;
	
	@PostMapping("/book")
	public String bookMovie(@RequestBody MovieBooking movieBooking) {
		try {
			iMovieBooking.save(movieBooking);
			return "Movie Booked";
		} catch (Exception e) {
			return "Booking Failed!";
		}
		
		
	}
	
	@GetMapping("/allBooking")
	public List<MovieBooking> getAllBooking()
	{
		return iMovieBooking.findAll();
	}
	@GetMapping("/admin/allBooking")
	public List<MovieBooking> allBooking()
	{
		return iMovieBooking.findAll();
	}
	
	@DeleteMapping("/cancelBooking/{id}")
	public String cancelBooking(@PathVariable("id") int id) {
		try {
			iMovieBooking.deleteById(id);
		return "Booking Cancelled";
		} catch (Exception e) {
			return "Booking cancellation failed";
		}
		
	}
	
	
}
