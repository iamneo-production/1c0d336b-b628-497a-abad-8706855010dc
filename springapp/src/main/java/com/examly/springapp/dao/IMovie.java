package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.Movie;

public interface IMovie extends JpaRepository<Movie, Integer>{

}
