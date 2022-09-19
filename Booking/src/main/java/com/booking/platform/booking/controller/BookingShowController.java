package com.booking.platform.booking.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.platform.booking.exception.ResourceNotFoundException;
import com.booking.platform.booking.model.BookingShows;
import com.booking.platform.booking.repository.BookingShowsRepository;
import com.booking.platform.booking.services.SequenceGeneratorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/booking")
public class BookingShowController {
	@Autowired
	private BookingShowsRepository bookingShowsRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/booking")
	public List<BookingShows> getAllBookingShowss() {
		return bookingShowsRepository.findAll();
	}

	@GetMapping("/booking/{id}")
	public ResponseEntity<BookingShows> getBookingShowsById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		BookingShows employee = bookingShowsRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("BookingShows not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/booking")
	public BookingShows createBookingShows(@Valid @RequestBody BookingShows employee) {
		employee.setId(sequenceGeneratorService.generateSequence(BookingShows.SEQUENCE_NAME));
		return bookingShowsRepository.save(employee);
	}

	
	@DeleteMapping("/booking/{id}")
	public Map<String, Boolean> deleteBookingShows(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		BookingShows employee = bookingShowsRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("BookingShows not found for this id :: " + employeeId));

		bookingShowsRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
