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
import com.booking.platform.theatreshows.entity.BkpScreen;
import com.booking.platform.theatreshows.entity.BkpTheatre;
import com.booking.platform.theatreshows.models.ScreenDto;
import com.booking.platform.theatreshows.models.TheatreDto;
import com.booking.platform.theatreshows.repository.CityRepository;
import com.booking.platform.theatreshows.repository.ScreenRepository;
import com.booking.platform.theatreshows.repository.TheatreRepository;
import com.booking.platform.theatreshows.services.LocationServices;
import com.booking.platform.theatreshows.services.TheatreServices;

import org.modelmapper.ModelMapper;

@Service
public class TheatreServicesImpl implements TheatreServices {

	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	CityRepository cityRepository;

	@Override
	public TheatreDto saveTheatre(TheatreDto theatreDto) {
		System.out.println("service::saveTheatre");
		BkpTheatre bkpTheatre=new BkpTheatre();
		Optional<BkpTheatre> bkpTheatreGet = Optional.empty();
		Optional<BkpCity> bkpCityGet = Optional.empty();
		if(theatreDto.getId()!=null ) {
	 bkpTheatreGet=theatreRepository.findById(theatreDto.getId());	
			}
		if(theatreDto.getCityId()!=null ) {
			bkpCityGet=cityRepository.findById(theatreDto.getCityId());	
			}
		if(bkpCityGet.isPresent()) {
		bkpTheatre.setCity(bkpCityGet.get());
		bkpTheatre.setTheatreName(theatreDto.getTheatreName());
		bkpTheatre.setActiveFlag(theatreDto.getActiveFlag());		
		bkpTheatre.setModifiedBy(theatreDto.getModifiedBy());
		bkpTheatre.setLastModifiedDate(LocalDateTime.now());
		if(bkpTheatreGet.isPresent()) {
		bkpTheatre.setCreatedDate(bkpTheatreGet.get().getCreatedDate());
		bkpTheatre.setCreatedBy(bkpTheatreGet.get().getCreatedBy());
		bkpTheatre.setId(bkpTheatreGet.get().getId());
		}
		else {
			bkpTheatre.setCreatedBy(theatreDto.getCreatedBy());
			bkpTheatre.setCreatedDate(LocalDateTime.now());
		}
		
		theatreRepository.save(bkpTheatre);
		}
		return theatreDto;		
	}
	
	@Override
	public List<TheatreDto> saveAllTheatres(List<TheatreDto> theatres) {
		// TODO Auto-generated method stub
		List<BkpTheatre> bkpTheatres=new ArrayList<BkpTheatre>();
		theatres.forEach(theatreDto->{
		BkpTheatre bkpTheatre=new BkpTheatre();
		Optional<BkpTheatre> bkpTheatreGet = Optional.empty();
		Optional<BkpCity> bkpCityGet = Optional.empty();
		if(theatreDto.getId()!=null ) {
	 bkpTheatreGet=theatreRepository.findById(theatreDto.getId());	
			}
		if(theatreDto.getCityId()!=null ) {
			bkpCityGet=cityRepository.findById(theatreDto.getCityId());	
			}
		if(bkpCityGet.isPresent()) {
			bkpTheatre.setCity(bkpCityGet.get());
			bkpTheatre.setTheatreName(theatreDto.getTheatreName());
			bkpTheatre.setActiveFlag(theatreDto.getActiveFlag());		
			bkpTheatre.setModifiedBy(theatreDto.getModifiedBy());
			bkpTheatre.setLastModifiedDate(LocalDateTime.now());
			if(bkpTheatreGet.isPresent()) {
			bkpTheatre.setCreatedDate(bkpTheatreGet.get().getCreatedDate());
			bkpTheatre.setCreatedBy(bkpTheatreGet.get().getCreatedBy());
			bkpTheatre.setId(bkpTheatreGet.get().getId());
			}
			else {
				bkpTheatre.setCreatedBy(theatreDto.getCreatedBy());
				bkpTheatre.setCreatedDate(LocalDateTime.now());
			}
		bkpTheatres.add(bkpTheatre);
		}
		});
		theatreRepository.saveAll(bkpTheatres);
		
		return theatres;
	}

	@Override
	public List<TheatreDto> getAllTheatres() {
		List<BkpTheatre> bkpTheatres=theatreRepository.findAll();
		List<TheatreDto> theatres=new ArrayList<TheatreDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpTheatres.forEach(c->{
			TheatreDto Theatre=modelMapper.map(c,TheatreDto.class);
			theatres.add(Theatre);
			});
		return theatres;
	}

	@Override
	public List<TheatreDto> getAllTheatresByStatus(String activeFlag) {
		List<BkpTheatre> bkpTheatres=theatreRepository.findByActiveFlag(activeFlag);
		List<TheatreDto> theatres=new ArrayList<TheatreDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpTheatres.forEach(c->{
			TheatreDto Theatre=modelMapper.map(c,TheatreDto.class);
			theatres.add(Theatre);
			});
		return theatres;
	}

	@Override
	public TheatreDto getTheatreById(UUID id) {
		Optional<BkpTheatre> bkpTheatre=theatreRepository.findById(id);		
		TheatreDto theatre=new TheatreDto();
		if(bkpTheatre.isPresent()) {
		ModelMapper modelMapper = new ModelMapper();
		theatre=modelMapper.map(bkpTheatre.get(),TheatreDto.class);		
		}
		return theatre;
	}

	@Override
	public ScreenDto saveScreen(ScreenDto screenDto) {
		System.out.println("service::saveScreen");
		BkpScreen bkpScreen=new BkpScreen();
		Optional<BkpScreen> bkpScreenGet = Optional.empty();
		Optional<BkpTheatre> BkpTheatreGet = Optional.empty();
		if(screenDto.getId()!=null ) {
			bkpScreenGet=screenRepository.findById(screenDto.getId());	
			}
		if(screenDto.getTheatreId()!=null ) {
			BkpTheatreGet=theatreRepository.findById(screenDto.getTheatreId());	
			}
		if(BkpTheatreGet.isPresent()) {
		bkpScreen.setTheatre(BkpTheatreGet.get());
		bkpScreen.setScreenName(screenDto.getScreenName());
		bkpScreen.setActiveFlag(screenDto.getActiveFlag());		
		bkpScreen.setModifiedBy(screenDto.getModifiedBy());
		bkpScreen.setLastModifiedDate(LocalDateTime.now());
		bkpScreen.setTotalSeats(screenDto.getTotalSeats());
		if(bkpScreenGet.isPresent()) {
			bkpScreen.setCreatedDate(bkpScreenGet.get().getCreatedDate());
			bkpScreen.setCreatedBy(bkpScreenGet.get().getCreatedBy());
			bkpScreen.setId(bkpScreenGet.get().getId());
		}
		else {
			bkpScreen.setCreatedBy(screenDto.getCreatedBy());
			bkpScreen.setCreatedDate(LocalDateTime.now());
		}
		
		screenRepository.save(bkpScreen);
		}
		return screenDto;	
	}
	

	@Override
	public List<ScreenDto> saveAllScreens(List<ScreenDto> screens) {
		// TODO Auto-generated method stub
		List<BkpScreen> bkpScreens=new ArrayList<BkpScreen>();
		screens.forEach(screenDto->{
		BkpScreen bkpScreen=new BkpScreen();
		Optional<BkpScreen> bkpScreenGet = Optional.empty();
		Optional<BkpTheatre> BkpTheatreGet = Optional.empty();
		if(screenDto.getId()!=null ) {
			bkpScreenGet=screenRepository.findById(screenDto.getId());	
			}
		if(screenDto.getTheatreId()!=null ) {
			BkpTheatreGet=theatreRepository.findById(screenDto.getTheatreId());	
			}
		if(BkpTheatreGet.isPresent()) {
		bkpScreen.setTheatre(BkpTheatreGet.get());
		bkpScreen.setScreenName(screenDto.getScreenName());
		bkpScreen.setActiveFlag(screenDto.getActiveFlag());		
		bkpScreen.setModifiedBy(screenDto.getModifiedBy());
		bkpScreen.setLastModifiedDate(LocalDateTime.now());
		bkpScreen.setTotalSeats(screenDto.getTotalSeats());
		if(bkpScreenGet.isPresent()) {
			bkpScreen.setCreatedDate(bkpScreenGet.get().getCreatedDate());
			bkpScreen.setCreatedBy(bkpScreenGet.get().getCreatedBy());
			bkpScreen.setId(bkpScreenGet.get().getId());
		}
		else {
			bkpScreen.setCreatedBy(screenDto.getCreatedBy());
			bkpScreen.setCreatedDate(LocalDateTime.now());
		}
		bkpScreens.add(bkpScreen);
		}});
		screenRepository.saveAll(bkpScreens);
		return screens;
	}

	@Override
	public List<ScreenDto> getAllscreens() {
		List<BkpScreen> bkpscreens=screenRepository.findAll();
		List<ScreenDto> screens=new ArrayList<ScreenDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpscreens.forEach(c->{
			ScreenDto screenDto=modelMapper.map(c,ScreenDto.class);
			screenDto.setTheatreId(c.getTheatre().getId());
			screens.add(screenDto);
			});
		return screens;
	}

	@Override
	public List<ScreenDto> getAllscreensByStatus(String activeFlag) {
		List<BkpScreen> bkpscreens=screenRepository.findByActiveFlag(activeFlag);
		List<ScreenDto> screens=new ArrayList<ScreenDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpscreens.forEach(c->{
			ScreenDto screenDto=modelMapper.map(c,ScreenDto.class);
			screenDto.setTheatreId(c.getTheatre().getId());
			screens.add(screenDto);
			});
		return screens;
	}

	@Override
	public ScreenDto getScreenById(UUID id) {
		Optional<BkpScreen> bkpScreen=screenRepository.findById(id);		
		ScreenDto screenDto=new ScreenDto();
		if(bkpScreen.isPresent()) {
		ModelMapper modelMapper = new ModelMapper();
		screenDto=modelMapper.map(bkpScreen.get(),ScreenDto.class);	
		screenDto.setTheatreId(bkpScreen.get().getTheatre().getId());
		}
		return screenDto;
	}

	


}
