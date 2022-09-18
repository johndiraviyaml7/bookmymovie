package com.booking.platform.theatreshows.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.platform.theatreshows.models.CityDto;
import com.booking.platform.theatreshows.models.CountryDto;
import com.booking.platform.theatreshows.services.LocationServices;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/location")
public class LocationController {
	
	@Autowired
	LocationServices locationServices;
	
	@PostMapping("/country")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveCountry(@RequestBody CountryDto countryDto) {
		System.out.println("controller::saveCountry");
		locationServices.saveCountry(countryDto);
		return ResponseEntity.ok().body("Country is added successfully");
		
	}
	
	@GetMapping("/country/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<CountryDto>> getAllCountries() {
		System.out.println("controller::getAllCountries");
		
		return ResponseEntity.ok().body(locationServices.getAllCountries());
		
	}
	
	@GetMapping("/country/status/{activeFlag}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<CountryDto>> getAllCountriesByStatus(@PathVariable("activeFlag") String activeFlag) {
		System.out.println("controller::getAllCountriesByStatus");
		
		return ResponseEntity.ok().body(locationServices.getAllCountriesByStatus(activeFlag));
		
	}
	
	@GetMapping("/country/allactive")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<CountryDto>> getAllActiveCountries()  {
		System.out.println("controller::getAllActiveCountries");
		
		return ResponseEntity.ok().body(locationServices.getAllCountriesByStatus("Y"));
		
	}
	
	@GetMapping("/country/{id}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<CountryDto> getCountryById(@PathVariable("id") UUID id) {
				
		return ResponseEntity.ok().body(locationServices.getCountryById(id));
		
	}
	
	@PutMapping("/country")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<?> updateCountry(@RequestBody CountryDto countryDto) {
		System.out.println("controller::updateCountry");
		locationServices.saveCountry(countryDto);
		return ResponseEntity.ok().body("Country is updated successfully");
		
	}

	@PostMapping("/city")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveCity(@RequestBody CityDto cityDto) {
		System.out.println("controller::saveCity");
		locationServices.saveCity(cityDto);
		return ResponseEntity.ok().body("Country is added successfully");
		
	}
	
	@GetMapping("/city/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<CityDto>> getAllCities() {
		System.out.println("controller::getAllCities");
		
		return ResponseEntity.ok().body(locationServices.getAllCities());
		
	}
	
	@GetMapping("/city/allactive")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<CityDto>> getAllActiveCities()  {
		System.out.println("controller::getAllActiveCountries");
		
		return ResponseEntity.ok().body(locationServices.getAllCitiesByStatus("Y"));
		
	}
	
	@GetMapping("/city/status/{activeFlag}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<CityDto>> getAllCitiesByStatus(@PathVariable("activeFlag") String activeFlag) {
		System.out.println("controller::getAllCitiesByStatus");
		
		return ResponseEntity.ok().body(locationServices.getAllCitiesByStatus(activeFlag));
		
	}
	
	@GetMapping("/city/{id}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<CityDto> getCityById(@PathVariable("id") UUID id) {
				
		return ResponseEntity.ok().body(locationServices.getCityById(id));
		
	}
	
	@PutMapping("/city")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<?> updateCity(@RequestBody CityDto CityDto) {
		System.out.println("controller::updateCity");
		locationServices.saveCity(CityDto);
		return ResponseEntity.ok().body("City is updated successfully");
		
	}

}
