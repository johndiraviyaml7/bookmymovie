package com.booking.platform.theatreshows.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.booking.platform.theatreshows.entity.BkpGenre;
import com.booking.platform.theatreshows.entity.EGenre;
import com.booking.platform.theatreshows.entity.ELanguages;

public class MoviesDto extends BaseModelDto implements Serializable  {
	
	private static final long serialVersionUID= 1L;

	public MoviesDto() {
		// TODO Auto-generated constructor stub
	}

	private String movieName;	 
	
	private Set<ELanguages> languages = new HashSet<>();  

	private LocalDateTime releaseDate;
		
	private Set<EGenre> bkpGenre = new HashSet<>();  
	
	private String synopsis;
	
	private String crewDetails;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	 

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	 

	public Set<ELanguages> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<ELanguages> languages) {
		this.languages = languages;
	}

	public Set<EGenre> getBkpGenre() {
		return bkpGenre;
	}

	public void setBkpGenre(Set<EGenre> bkpGenre) {
		this.bkpGenre = bkpGenre;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getCrewDetails() {
		return crewDetails;
	}

	public void setCrewDetails(String crewDetails) {
		this.crewDetails = crewDetails;
	}
	
	
	
}
