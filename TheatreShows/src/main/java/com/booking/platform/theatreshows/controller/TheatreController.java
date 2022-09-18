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

import com.booking.platform.theatreshows.models.ScreenDto;
import com.booking.platform.theatreshows.models.TheatreDto;
import com.booking.platform.theatreshows.services.LocationServices;
import com.booking.platform.theatreshows.services.TheatreServices;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/location")
public class TheatreController {
	
	@Autowired
	TheatreServices theatreServices;
	
	@PostMapping("/theatre")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveTheatre(@RequestBody TheatreDto theatreDto) {
		System.out.println("controller::saveTheatre");
		theatreServices.saveTheatre(theatreDto);
		return ResponseEntity.ok().body("Theatre is added successfully");
		
	}
	@PostMapping("/theatre/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveAllTheatres(@RequestBody List<TheatreDto> theatres) {
		System.out.println("controller::saveAllTheatres");
		theatreServices.saveAllTheatres(theatres);
		return ResponseEntity.ok().body("Theatre is added successfully");
		
	}
	@GetMapping("/theatre/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<TheatreDto>> getAllTheatres() {
		System.out.println("controller::getAllTheatres");
		
		return ResponseEntity.ok().body(theatreServices.getAllTheatres());
		
	}
	
	@GetMapping("/theatre/status/{activeFlag}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<TheatreDto>> getAllTheatresByStatus(@PathVariable("activeFlag") String activeFlag) {
		System.out.println("controller::getAllTheatresByStatus");
		
		return ResponseEntity.ok().body(theatreServices.getAllTheatresByStatus(activeFlag));
		
	}
	
	@GetMapping("/theatre/allactive")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<TheatreDto>> getAllActiveTheatres()  {
		System.out.println("controller::getAllActiveTheatres");
		
		return ResponseEntity.ok().body(theatreServices.getAllTheatresByStatus("Y"));
		
	}
	
	@GetMapping("/theatre/{id}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<TheatreDto> getTheatreById(@PathVariable("id") UUID id) {
				
		return ResponseEntity.ok().body(theatreServices.getTheatreById(id));
		
	}
	
	@PutMapping("/theatre")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<?> updateTheatre(@RequestBody TheatreDto theatreDto) {
		System.out.println("controller::updateTheatre");
		theatreServices.saveTheatre(theatreDto);
		return ResponseEntity.ok().body("Theatre is updated successfully");
		
	}

	@PostMapping("/screen")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveScreen(@RequestBody ScreenDto screenDto) {
		System.out.println("controller::saveScreen");
		theatreServices.saveScreen(screenDto);
		return ResponseEntity.ok().body("Theatre is added successfully");
		
	}
	
	@PostMapping("/screen/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<String> saveAllScreens(@RequestBody List<ScreenDto> screens) {
		System.out.println("controller::saveAllScreens");
		theatreServices.saveAllScreens(screens);
		return ResponseEntity.ok().body("Theatre is added successfully");
		
	}
	
	@GetMapping("/screen/all")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<ScreenDto>> getAllScreens() {
		System.out.println("controller::getAllScreens");
		
		return ResponseEntity.ok().body(theatreServices.getAllscreens());
		
	}
	
	@GetMapping("/screen/allactive")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<ScreenDto>> getAllActiveScreens()  {
		System.out.println("controller::getAllActiveTheatres");
		
		return ResponseEntity.ok().body(theatreServices.getAllscreensByStatus("Y"));
		
	}
	
	@GetMapping("/screen/status/{activeFlag}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<List<ScreenDto>> getAllScreensByStatus(@PathVariable("activeFlag") String activeFlag) {
		System.out.println("controller::getAllScreensByStatus");
		
		return ResponseEntity.ok().body(theatreServices.getAllscreensByStatus(activeFlag));
		
	}
	
	@GetMapping("/screen/{id}")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<ScreenDto> getScreenById(@PathVariable("id") UUID id) {
				
		return ResponseEntity.ok().body(theatreServices.getScreenById(id));
		
	}
	
	@PutMapping("/screen")
	@ApiOperation(value = "This method is used to get the clients.")
	public ResponseEntity<?> updateScreen(@RequestBody ScreenDto ScreenDto) {
		System.out.println("controller::updateScreen");
		theatreServices.saveScreen(ScreenDto);
		return ResponseEntity.ok().body("Screen is updated successfully");
		
	}

}
