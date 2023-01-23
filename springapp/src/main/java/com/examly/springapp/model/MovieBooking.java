package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "movie_bookings")
public class MovieBooking {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id",unique = true,nullable = false)
	private int bookingId;
	
	@Column(name = "customer_username")
	private String customerUsername;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "no_of_seats")
	private int noOfSeats;
	
	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public String getCustomerUsername() {
		return customerUsername;
	}



	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}



	public String getMovieName() {
		return movieName;
	}



	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	public int getNoOfSeats() {
		return noOfSeats;
	}



	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


}
