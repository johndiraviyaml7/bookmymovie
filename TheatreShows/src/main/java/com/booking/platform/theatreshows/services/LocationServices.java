package com.booking.platform.theatreshows.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.platform.theatreshows.models.CityDto;
import com.booking.platform.theatreshows.models.CountryDto;

@Service
public interface LocationServices {
	public CountryDto saveCountry(CountryDto countryDto);

	public List<CountryDto> getAllCountries();
	public List<CountryDto> getAllCountriesByStatus(String activeFlag);

	public CountryDto getCountryById(UUID id);

	public CityDto saveCity(CityDto cityDto);

	public  List<CityDto> getAllCities();

	public  List<CityDto> getAllCitiesByStatus(String activeFlag);

	public CityDto getCityById(UUID id);

}
