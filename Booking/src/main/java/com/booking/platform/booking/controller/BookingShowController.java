package com.booking.platform.booking.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.platform.booking.exception.ResourceNotFoundException;
import com.booking.platform.booking.model.BookingShows;
import com.booking.platform.booking.services.BookShowsServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/booking")
public class BookingShowController {
	 

	@Autowired
	private BookShowsServices bookShowsServices;
	
	@GetMapping("/booking")
	public List<BookingShows> getAllBookingShows() {		
		return bookShowsServices.getAllBookingShows();
	}

	@GetMapping("/booking/{id}")
	public ResponseEntity<BookingShows> getBookingShowsById(@PathVariable(value = "id") Long bookmyshowId)
			throws ResourceNotFoundException {
		BookingShows bookingShows = bookShowsServices.getBookingShowsById(bookmyshowId);
						 
		return ResponseEntity.ok().body(bookingShows);
	}

	@PostMapping("/booking")
	public BookingShows createBookingShows(@Valid @RequestBody BookingShows bookingShows) {
		BookingShows bookShows= bookShowsServices.createBookingShows(bookingShows);
		 
		return bookShows;
	}

	
	@DeleteMapping("/booking/{id}")
	public Map<String, Boolean> deleteBookingShows(@PathVariable(value = "id") Long bookmyshowId)
			throws ResourceNotFoundException {
		
		return bookShowsServices.deleteBookingShows(bookmyshowId);
		
	}
}
