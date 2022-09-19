package com.booking.platform.booking.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.booking.platform.booking.exception.ResourceNotFoundException;
import com.booking.platform.booking.model.BookingShows;
import com.booking.platform.booking.repository.BookingShowsRepository;
import com.booking.platform.booking.services.BookShowsServices;
import com.booking.platform.booking.services.SequenceGeneratorService;

public class BookShowsServicesImpl implements BookShowsServices {

	@Autowired
	private BookingShowsRepository bookingShowsRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public List<BookingShows> getAllBookingShows() {
		
		return bookingShowsRepository.findAll();
	}

	@Override
	public BookingShows getBookingShowsById(Long bookmyshowId) throws ResourceNotFoundException {
		BookingShows bookingShows = bookingShowsRepository.findById(bookmyshowId)
				.orElseThrow(() -> new ResourceNotFoundException("BookingShows not found for this id :: " + bookmyshowId));
		
		return bookingShows;
	}

	@Override
	public BookingShows createBookingShows(@Valid BookingShows bookingShows) {
		
		bookingShows.setId(sequenceGeneratorService.generateSequence(BookingShows.SEQUENCE_NAME));
		return bookingShowsRepository.save(bookingShows);
	}

	@Override
	public Map<String, Boolean> deleteBookingShows(Long bookmyshowId) throws ResourceNotFoundException {
		BookingShows bookingShows = bookingShowsRepository.findById(bookmyshowId)
				.orElseThrow(() -> new ResourceNotFoundException("BookingShows not found for this id :: " + bookmyshowId));

		bookingShowsRepository.delete(bookingShows);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	 

}
