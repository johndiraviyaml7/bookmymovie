package com.booking.platform.theatreshows.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.platform.theatreshows.entity.BkpCity;
import com.booking.platform.theatreshows.entity.BkpCountry;
import com.booking.platform.theatreshows.models.CityDto;
import com.booking.platform.theatreshows.models.CountryDto;
import com.booking.platform.theatreshows.repository.CityRepository;
import com.booking.platform.theatreshows.repository.CountryRepository;
import com.booking.platform.theatreshows.services.LocationServices;

import org.modelmapper.ModelMapper;

@Service
public class LocationServicesImpl implements LocationServices {

	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	CityRepository cityRepository;

	@Override
	public CountryDto saveCountry(CountryDto countryDto) {
		System.out.println("service::saveCountry");
		BkpCountry bkpCountry=new BkpCountry();
		Optional<BkpCountry> bkpCountryGet = Optional.empty();
		if(countryDto.getId()!=null ) {
	 bkpCountryGet=countryRepository.findById(countryDto.getId());	
			}
		bkpCountry.setCountryCode(countryDto.getCountryCode());
		bkpCountry.setCountryName(countryDto.getCountryName());
		bkpCountry.setActiveFlag(countryDto.getActiveFlag());		
		bkpCountry.setModifiedBy(countryDto.getModifiedBy());
		bkpCountry.setLastModifiedDate(LocalDateTime.now());
		if(bkpCountryGet.isPresent()) {
		bkpCountry.setCreatedDate(bkpCountryGet.get().getCreatedDate());
		bkpCountry.setCreatedBy(bkpCountryGet.get().getCreatedBy());
		bkpCountry.setId(bkpCountryGet.get().getId());
		} else {
			bkpCountry.setCreatedDate(LocalDateTime.now());
			bkpCountry.setCreatedBy(countryDto.getCreatedBy());
		}
		
		countryRepository.save(bkpCountry);
		return countryDto;		
	}

	@Override
	public List<CountryDto> getAllCountries() {
		List<BkpCountry> bkpCountries=countryRepository.findAll();
		List<CountryDto> countries=new ArrayList<CountryDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpCountries.forEach(c->{
			CountryDto country=modelMapper.map(c,CountryDto.class);
			countries.add(country);
			});
		return countries;
	}

	@Override
	public List<CountryDto> getAllCountriesByStatus(String activeFlag) {
		List<BkpCountry> bkpCountries=countryRepository.findByActiveFlag(activeFlag);
		List<CountryDto> countries=new ArrayList<CountryDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpCountries.forEach(c->{
			CountryDto country=modelMapper.map(c,CountryDto.class);
			countries.add(country);
			});
		return countries;
	}

	@Override
	public CountryDto getCountryById(UUID id) {
		Optional<BkpCountry> bkpCountry=countryRepository.findById(id);		
		CountryDto country=new CountryDto();
		if(bkpCountry.isPresent()) {
		ModelMapper modelMapper = new ModelMapper();
		country=modelMapper.map(bkpCountry.get(),CountryDto.class);		
		}
		return country;
	}

	@Override
	public CityDto saveCity(CityDto cityDto) {
		System.out.println("service::saveCity");
		BkpCity bkpCity=new BkpCity();
		Optional<BkpCity> BkpCityGet = Optional.empty();
		Optional<BkpCountry> BkpCountryGet = Optional.empty();
		if(cityDto.getId()!=null ) {
			BkpCityGet=cityRepository.findById(cityDto.getId());	
			}
		if(cityDto.getCountryId()!=null ) {
			BkpCountryGet=countryRepository.findById(cityDto.getCountryId());	
			}
		if(BkpCountryGet.isPresent()) {
		bkpCity.setCountry(BkpCountryGet.get());
		bkpCity.setCityName(cityDto.getCityName());
		bkpCity.setActiveFlag(cityDto.getActiveFlag());		
		bkpCity.setModifiedBy(cityDto.getModifiedBy());
		bkpCity.setLastModifiedDate(LocalDateTime.now());
		if(BkpCityGet.isPresent()) {
			bkpCity.setCreatedDate(BkpCityGet.get().getCreatedDate());
			bkpCity.setCreatedBy(BkpCityGet.get().getCreatedBy());
			bkpCity.setId(BkpCityGet.get().getId());
		} else {
			bkpCity.setCreatedDate(LocalDateTime.now());
			bkpCity.setCreatedBy(cityDto.getCreatedBy());
		}
		
		cityRepository.save(bkpCity);
		}
		return cityDto;	
	}

	@Override
	public List<CityDto> getAllCities() {
		List<BkpCity> bkpCities=cityRepository.findAll();
		List<CityDto> cities=new ArrayList<CityDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpCities.forEach(c->{
			CityDto cityDto=modelMapper.map(c,CityDto.class);
			cityDto.setCountryId(c.getCountry().getId());
			cities.add(cityDto);
			});
		return cities;
	}

	@Override
	public List<CityDto> getAllCitiesByStatus(String activeFlag) {
		List<BkpCity> bkpCities=cityRepository.findByActiveFlag(activeFlag);
		List<CityDto> cities=new ArrayList<CityDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpCities.forEach(c->{
			CityDto cityDto=modelMapper.map(c,CityDto.class);
			cityDto.setCountryId(c.getCountry().getId());
			cities.add(cityDto);
			});
		return cities;
	}

	@Override
	public CityDto getCityById(UUID id) {
		Optional<BkpCity> bkpCity=cityRepository.findById(id);		
		CityDto cityDto=new CityDto();
		if(bkpCity.isPresent()) {
		ModelMapper modelMapper = new ModelMapper();
		cityDto=modelMapper.map(bkpCity.get(),CityDto.class);	
		cityDto.setCountryId(bkpCity.get().getCountry().getId());
		}
		return cityDto;
	}

}
