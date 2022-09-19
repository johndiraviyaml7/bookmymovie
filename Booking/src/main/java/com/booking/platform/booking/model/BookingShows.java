package com.booking.platform.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "BookingShows")
public class BookingShows {

	@Transient
    public static final String SEQUENCE_NAME = "booking_sequence";
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private UUID movieId;
	private String movieName;
	private UUID screenId;
	private String screenName;
	private LocalDate scheduledDate;
	private String showTime;
	private Set<BookingSeats> bookSeats;
	
	
	
	public BookingShows() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UUID getMovieId() {
		return movieId;
	}

	public void setMovieId(UUID movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public UUID getScreenId() {
		return screenId;
	}

	public void setScreenId(UUID screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Set<BookingSeats> getBookSeats() {
		return bookSeats;
	}

	public void setBookSeats(Set<BookingSeats> bookSeats) {
		this.bookSeats = bookSeats;
	}

 

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	/**
	 * @param id
	 * @param movieId
	 * @param movieName
	 * @param screenId
	 * @param screenName
	 * @param scheduledDate
	 * @param showTime
	 * @param bookSeats
	
	 */
	public BookingShows(long id, @NotBlank @Size(max = 100) UUID movieId, String movieName, UUID screenId,
			String screenName, LocalDate scheduledDate, String showTime, Set<BookingSeats> bookSeats) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.movieName = movieName;
		this.screenId = screenId;
		this.screenName = screenName;
		this.scheduledDate = scheduledDate;
		this.showTime = showTime;
		this.bookSeats = bookSeats;
		
	}

	@Override
	public String toString() {
		return "BookingShows [id=" + id + ", movieId=" + movieId + ", movieName=" + movieName + ", screenId=" + screenId
				+ ", screenName=" + screenName + ", scheduledDate=" + scheduledDate + ", showTime=" + showTime
				+ ", bookSeats=" + bookSeats  + ", getId()=" + getId() + ", getMovieId()="
				+ getMovieId() + ", getMovieName()=" + getMovieName() + ", getScreenId()=" + getScreenId()
				+ ", getScreenName()=" + getScreenName() + ", getScheduledDate()=" + getScheduledDate()
				+ ", getShowTime()=" + getShowTime() + ", getBookSeats()=" + getBookSeats() +  "]";
	}
	
	
}
