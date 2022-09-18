package com.booking.platform.theatreshows.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.platform.theatreshows.models.ScreenDto;
import com.booking.platform.theatreshows.models.TheatreDto;

@Service
public interface TheatreServices {
	public TheatreDto saveTheatre(TheatreDto theatreDto);
	public List<TheatreDto> saveAllTheatres(List<TheatreDto> theatres);

	public List<TheatreDto> getAllTheatres();
	public List<TheatreDto> getAllTheatresByStatus(String activeFlag);

	public TheatreDto getTheatreById(UUID id);

	public ScreenDto saveScreen(ScreenDto screenDto);
	public List<ScreenDto> saveAllScreens(List<ScreenDto> screenDto);

	public  List<ScreenDto> getAllscreens();

	public  List<ScreenDto> getAllscreensByStatus(String activeFlag);

	public ScreenDto getScreenById(UUID id);

}
