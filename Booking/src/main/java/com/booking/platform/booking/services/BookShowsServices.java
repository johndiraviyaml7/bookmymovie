package com.booking.platform.booking.services;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.booking.platform.booking.exception.ResourceNotFoundException;
import com.booking.platform.booking.model.BookingShows;

@Service
public interface BookShowsServices {

	public List<BookingShows> getAllBookingShows();

	public BookingShows getBookingShowsById(Long bookmyshowId) throws ResourceNotFoundException;

	public BookingShows createBookingShows(@Valid BookingShows bookingShows);

	public Map<String, Boolean> deleteBookingShows(Long bookmyshowId)  throws ResourceNotFoundException;

}
