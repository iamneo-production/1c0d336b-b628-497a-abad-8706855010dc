package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.MovieBooking;

public interface IMovieBooking extends JpaRepository<MovieBooking, Integer> {

}
