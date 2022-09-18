package com.booking.platform.theatreshows.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.platform.theatreshows.models.MoviesDto;
import com.booking.platform.theatreshows.models.ScreenDto;
import com.booking.platform.theatreshows.models.TheatreDto;
import com.booking.platform.theatreshows.models.TheatreMoviesDto;
import com.booking.platform.theatreshows.services.LocationServices;
import com.booking.platform.theatreshows.services.MoviesServices;
import com.booking.platform.theatreshows.services.TheatreServices;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/location")
public class MoviesController {
	
	@Autowired
	MoviesServices moviesServices;
	
	@PostMapping("/movies")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveMovie(@RequestBody MoviesDto moviesDto) {
		System.out.println("controller::saveMovie");
		moviesServices.saveMovies(moviesDto);
		return ResponseEntity.ok().body("Movie is added successfully");
		
	}
	
	@PostMapping("/movies/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveAllMovies(@RequestBody List<MoviesDto> moviesList) {
		System.out.println("controller::saveAllTheatres");
		moviesServices.saveAllMovies(moviesList);
		return ResponseEntity.ok().body("Movies are added successfully");
		
	}
	@GetMapping("/movies/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<MoviesDto>> getAllMovies() {
		System.out.println("controller::getAllMovies");
		
		return ResponseEntity.ok().body(moviesServices.getAllMovies());
		
	}
	
	
	
	
	@GetMapping("/movies/{id}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<MoviesDto> getMoviesById(@PathVariable("id") UUID id) {
				
		return ResponseEntity.ok().body(moviesServices.getMoviesById(id));
		
	}
	
	@PutMapping("/movies")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<?> updateMovie(@RequestBody MoviesDto moviesDto) {
		System.out.println("controller::updateMovie");
		moviesServices.saveMovies(moviesDto);
		return ResponseEntity.ok().body("Theatre is updated successfully");
		
	}

	
	@PostMapping("/theatremovies")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveTheatreMovie(@RequestBody TheatreMoviesDto TheatreMoviesDto) {
		System.out.println("controller::saveTheatreMovie");
		moviesServices.saveTheatreMovies(TheatreMoviesDto);
		return ResponseEntity.ok().body("TheatreMovie is added successfully");
		
	}
	
	@PostMapping("/theatremovies/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveAllTheatreMovies(@RequestBody List<TheatreMoviesDto> TheatreMoviesList) {
		System.out.println("controller::saveAllTheatres");
		moviesServices.saveAllTheatreMovies(TheatreMoviesList);
		return ResponseEntity.ok().body("TheatreMovies are added successfully");
		
	}
	@GetMapping("/theatremovies/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<TheatreMoviesDto>> getAllTheatreMovies() {
		System.out.println("controller::getAllTheatreMovies");
		
		return ResponseEntity.ok().body(moviesServices.getAllTheatreMovies());
		
	}
	
	
	
	
	@GetMapping("/theatremovies/{id}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<TheatreMoviesDto> getTheatreMoviesById(@PathVariable("id") UUID id) {
				
		return ResponseEntity.ok().body(moviesServices.getTheatreMoviesById(id));
		
	}
	
	@PutMapping("/theatremovies")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<?> updateTheatreMovie(@RequestBody TheatreMoviesDto TheatreMoviesDto) {
		System.out.println("controller::updateTheatreMovie");
		moviesServices.saveTheatreMovies(TheatreMoviesDto);
		return ResponseEntity.ok().body("Theatre is updated successfully");
		
	}

}
