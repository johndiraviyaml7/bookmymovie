package com.booking.platform.theatreshows.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.booking.platform.theatreshows.entity.ELanguages;

public class TheatreMoviesDto extends BaseModelDto implements Serializable  {
	
	private static final long serialVersionUID= 1L;

	public TheatreMoviesDto() {
		// TODO Auto-generated constructor stub
	}

	
	private UUID theatreId;	
	private String theatreName;
	private UUID moviesId;
	private String movieName;
	
	private Set<ELanguages> languages = new HashSet<>();  
	
	public UUID getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(UUID theatreId) {
		this.theatreId = theatreId;
	}
	public UUID getMoviesId() {
		return moviesId;
	}
	public void setMoviesId(UUID moviesId) {
		this.moviesId = moviesId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Set<ELanguages> getLanguages() {
		return languages;
	}
	public void setLanguages(Set<ELanguages> languages) {
		this.languages = languages;
	}

		
	
	
}
