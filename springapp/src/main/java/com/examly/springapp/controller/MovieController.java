package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IMovie;
import com.examly.springapp.model.Movie;

@RestController
public class MovieController {
	
	@Autowired
	IMovie iMovie;

	@GetMapping("/allMovies")
	public List<Movie> getAllMovie(){
		return iMovie.findAll();
	}
	@GetMapping("/admin")
	public List<Movie> allMovie(){
		return iMovie.findAll();
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovie(@PathVariable("id") int id) {
		try {
			Optional<Movie> movie= iMovie.findById(id);
			if(movie.isEmpty()) return null;
			return movie.get();
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/admin/movie")
	public String addMovie(@RequestBody Movie movie) {
		try {
			iMovie.save(movie);
			return "Movie added";
		} catch (Exception e) {
			return "Movie already exist";
		}
	}
	
	@DeleteMapping("/admin/movie/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		try {
			iMovie.deleteById(id);
			return "Movie deleted";
		} catch (Exception e) {
			e.printStackTrace();
			return "Movie delete operation failed";
		}
	
		
	}
	
	@PutMapping("/admin/movie/{id}")
	public Movie updateMovie(@PathVariable("id") int id,@RequestBody Movie movie) {
		try {
			Optional<Movie> movieObtained=iMovie.findById(id);
			if(movieObtained.isEmpty()) return null;
			movieObtained.map(m->{
				m.setName(movie.getName());
				m.setDescription(movie.getDescription());
				m.setDirector(movie.getDirector());
				return iMovie.save(m);
			});
			return movie;
		} catch (Exception e) {
			return null;
		}
	}
}
