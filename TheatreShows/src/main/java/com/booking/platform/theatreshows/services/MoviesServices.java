package com.booking.platform.theatreshows.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.platform.theatreshows.models.MoviesDto;
import com.booking.platform.theatreshows.models.TheatreMoviesDto;

@Service
public interface MoviesServices {
	public MoviesDto saveMovies(MoviesDto theatreDto);

	public List<MoviesDto> saveAllMovies(List<MoviesDto> moviesList);

	public  List<MoviesDto>  getAllMovies();

	public MoviesDto getMoviesById(UUID id);

	public TheatreMoviesDto saveTheatreMovies(TheatreMoviesDto theatreMoviesDto);

	public List<TheatreMoviesDto> saveAllTheatreMovies(List<TheatreMoviesDto> theatreMoviesList);

	public List<TheatreMoviesDto> getAllTheatreMovies();

	public TheatreMoviesDto getTheatreMoviesById(UUID id);
	

}
