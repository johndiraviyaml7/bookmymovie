package com.booking.platform.theatreshows.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.platform.theatreshows.entity.BkpGenre;
import com.booking.platform.theatreshows.entity.BkpLanguages;
import com.booking.platform.theatreshows.entity.BkpMovies;
import com.booking.platform.theatreshows.entity.BkpTheartreMovies;
import com.booking.platform.theatreshows.entity.BkpTheatre;
import com.booking.platform.theatreshows.entity.EGenre;
import com.booking.platform.theatreshows.entity.ELanguages;
import com.booking.platform.theatreshows.models.MoviesDto;
import com.booking.platform.theatreshows.models.TheatreDto;
import com.booking.platform.theatreshows.models.TheatreMoviesDto;
import com.booking.platform.theatreshows.repository.CityRepository;
import com.booking.platform.theatreshows.repository.GenreRepository;
import com.booking.platform.theatreshows.repository.LanguageRepository;
import com.booking.platform.theatreshows.repository.MoviesRepository;
import com.booking.platform.theatreshows.repository.ScreenRepository;
import com.booking.platform.theatreshows.repository.TheatreMoviesRepository;
import com.booking.platform.theatreshows.repository.TheatreRepository;
import com.booking.platform.theatreshows.services.MoviesServices;

@Service
public class MoviesServicesImpl implements MoviesServices {

	@Autowired
	MoviesRepository moviesRepository;
	
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	TheatreMoviesRepository theatreMoviesRepository;
		
	@Autowired
	LanguageRepository languageRepository;
	
	@Override
	public MoviesDto saveMovies(MoviesDto moviesDto) {
		System.out.println("service::saveMovies");
		BkpMovies bkpMovies=new BkpMovies();
		Optional<BkpMovies> bkpMoviesGet = Optional.empty();
		
		if(moviesDto.getId()!=null ) {
	 bkpMoviesGet=moviesRepository.findById(moviesDto.getId());	
			}
		if(moviesDto.getLanguages()!=null && moviesDto.getLanguages().size()>0)
		{
			bkpMovies.setLanguages(getListOfGenresLanguages(moviesDto.getLanguages()));				
		}
		if(moviesDto.getBkpGenre()!=null && moviesDto.getBkpGenre().size()>0)
		{
			bkpMovies.setBkpGenre(getListOfGenres(moviesDto.getBkpGenre()));		
		} 	
		bkpMovies.setMovieName(moviesDto.getMovieName());
		bkpMovies.setActiveFlag(moviesDto.getActiveFlag());		
		bkpMovies.setModifiedBy(moviesDto.getModifiedBy());
		bkpMovies.setLastModifiedDate(LocalDateTime.now());
		bkpMovies.setCrewDetails(moviesDto.getCrewDetails());
		bkpMovies.setSynopsis(moviesDto.getSynopsis());
		bkpMovies.setReleaseDate(moviesDto.getReleaseDate());
		
		if(bkpMoviesGet.isPresent()) {
		bkpMovies.setCreatedDate(bkpMoviesGet.get().getCreatedDate());
		bkpMovies.setCreatedBy(bkpMoviesGet.get().getCreatedBy());
		bkpMovies.setId(bkpMoviesGet.get().getId());
		}
		else {
			bkpMovies.setCreatedBy(moviesDto.getCreatedBy());
			bkpMovies.setCreatedDate(LocalDateTime.now());
		}
		
		moviesRepository.save(bkpMovies);
		
		return moviesDto;		
	}


	@Autowired
	GenreRepository genreRepository;

	@Override
	public List<MoviesDto> saveAllMovies(List<MoviesDto> moviesList) {
		List<BkpMovies> bkpMoviesList = new ArrayList<BkpMovies>();
		moviesList.forEach(moviesDto->{
		System.out.println("service::saveMovies");
		BkpMovies bkpMovies=new BkpMovies();
		Optional<BkpMovies> bkpMoviesGet = Optional.empty();
		
		if(moviesDto.getId()!=null ) {
	 bkpMoviesGet=moviesRepository.findById(moviesDto.getId());	
			}
		if(moviesDto.getLanguages()!=null && moviesDto.getLanguages().size()>0)
		{
			bkpMovies.setLanguages(getListOfGenresLanguages(moviesDto.getLanguages()));				
		}
		if(moviesDto.getBkpGenre()!=null && moviesDto.getBkpGenre().size()>0)
		{
			bkpMovies.setBkpGenre(getListOfGenres(moviesDto.getBkpGenre()));		
		} 	
		bkpMovies.setMovieName(moviesDto.getMovieName());
		bkpMovies.setActiveFlag(moviesDto.getActiveFlag());		
		bkpMovies.setModifiedBy(moviesDto.getModifiedBy());
		bkpMovies.setLastModifiedDate(LocalDateTime.now());
		bkpMovies.setCrewDetails(moviesDto.getCrewDetails());
		bkpMovies.setSynopsis(moviesDto.getSynopsis());
		bkpMovies.setReleaseDate(moviesDto.getReleaseDate());
		
		if(bkpMoviesGet.isPresent()) {
		bkpMovies.setCreatedDate(bkpMoviesGet.get().getCreatedDate());
		bkpMovies.setCreatedBy(bkpMoviesGet.get().getCreatedBy());
		bkpMovies.setId(bkpMoviesGet.get().getId());
		}
		else {
			bkpMovies.setCreatedBy(moviesDto.getCreatedBy());
			bkpMovies.setCreatedDate(LocalDateTime.now());
		}
		bkpMoviesList.add(bkpMovies);
		});
		moviesRepository.saveAll(bkpMoviesList);
		
		return null;
	}


	@Override
	public List<MoviesDto> getAllMovies() {
		List<BkpMovies> bkpMovies=moviesRepository.findAll();
		List<MoviesDto> moviesList=new ArrayList<MoviesDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpMovies.forEach(c->{
			MoviesDto movies=modelMapper.map(c,MoviesDto.class);
			movies.setLanguages(getListOfELanguages(c.getLanguages()));
			movies.setBkpGenre(getListOfEGenres(c.getBkpGenre()));
			moviesList.add(movies);
			});
		return moviesList;
	}


	@Override
	public MoviesDto getMoviesById(UUID id) {
		MoviesDto moviesDto=new MoviesDto();
		Optional<BkpMovies> bkpMovies=moviesRepository.findById(id);
		ModelMapper modelMapper = new ModelMapper();	
		moviesDto=modelMapper.map(bkpMovies.get(),MoviesDto.class);
		moviesDto.setLanguages(getListOfELanguages(bkpMovies.get().getLanguages()));
		moviesDto.setBkpGenre(getListOfEGenres(bkpMovies.get().getBkpGenre()));
		return moviesDto;
	}


	private Set<BkpGenre> getListOfGenres(Set<EGenre> genres){
		Set<BkpGenre> generSet=new HashSet<>();
		List<BkpGenre> generList=genreRepository.findAll();
		Predicate<BkpGenre>  gnePredicator=x->genres.contains(x.getGenreName());
		 generList.stream().filter(gnePredicator).forEach(g->{generSet.add(g);});
				return generSet;		
			}

	private Set<BkpLanguages> getListOfGenresLanguages(Set<ELanguages> languages){
		Set<BkpLanguages> langSet=new HashSet<>();
		List<BkpLanguages> langList=languageRepository.findAll();
		Predicate<BkpLanguages>  gnePredicator=x->languages.contains(x.getLanguage());
		langList.stream().filter(gnePredicator).forEach(lang->{langSet.add(lang);});
				return langSet;		
			}
	private Set<BkpLanguages> getListOfMovieLanguages(Set<ELanguages> languages,Set<BkpLanguages> langList){
		Set<BkpLanguages> langSet=new HashSet<>();
		Predicate<BkpLanguages>  gnePredicator=x->languages.contains(x.getLanguage());
		langList.stream().filter(gnePredicator).forEach(lang->{langSet.add(lang);});
				return langSet;		
			}
	private Set<EGenre> getListOfEGenres(Set<BkpGenre> genres){
		Set<EGenre> generSet=new HashSet<>();
		genres.forEach(g->{generSet.add(g.getGenreName());}); 
		return generSet;		
			}

	private Set<ELanguages> getListOfELanguages(Set<BkpLanguages> languages){
		Set<ELanguages> langSet=new HashSet<>();
		languages.forEach(lang->{langSet.add(lang.getLanguage());});
		return langSet;		
			}


	@Override
	public TheatreMoviesDto saveTheatreMovies(TheatreMoviesDto theatreMoviesDto) {
		
		System.out.println("service::saveTheatreMovies");
		BkpTheartreMovies bkpTheartreMovies=new BkpTheartreMovies();
		Optional<BkpTheartreMovies> bkpTheartreMoviesGet = Optional.empty();
		Optional<BkpTheatre> bkpTheatreGet = Optional.empty();
		Optional<BkpMovies> bkpMoviesGet = Optional.empty();
		if(theatreMoviesDto.getId()!=null ) {
			bkpTheartreMoviesGet=theatreMoviesRepository.findById(theatreMoviesDto.getId());	
			}
		if(theatreMoviesDto.getTheatreId() !=null ) {
			 bkpTheatreGet=theatreRepository.findById(theatreMoviesDto.getTheatreId());	
			 bkpTheartreMovies.setTheatreIDD(bkpTheatreGet.get());
			
					}
		if(theatreMoviesDto.getMoviesId()!=null ) {
			 bkpMoviesGet=moviesRepository.findById(theatreMoviesDto.getMoviesId());	
			 
			 bkpTheartreMovies.setMovieIDD(bkpMoviesGet.get());	
			 if(theatreMoviesDto.getLanguages()!=null && theatreMoviesDto.getLanguages().size()>0)
				{
				 bkpTheartreMovies.setLanguages(getListOfMovieLanguages(theatreMoviesDto.getLanguages(),bkpMoviesGet.get().getLanguages()))	;		
				}
			
			}
			 	
		 
		bkpTheartreMovies.setActiveFlag(theatreMoviesDto.getActiveFlag());		
		bkpTheartreMovies.setModifiedBy(theatreMoviesDto.getModifiedBy());
		bkpTheartreMovies.setLastModifiedDate(LocalDateTime.now());
		
		if(bkpTheartreMoviesGet.isPresent()) {
			bkpTheartreMovies.setCreatedDate(bkpTheartreMoviesGet.get().getCreatedDate());
			bkpTheartreMovies.setCreatedBy(bkpTheartreMoviesGet.get().getCreatedBy());
			bkpTheartreMovies.setId(bkpTheartreMoviesGet.get().getId());
		}
		else {
			bkpTheartreMovies.setCreatedBy(theatreMoviesDto.getCreatedBy());
			bkpTheartreMovies.setCreatedDate(LocalDateTime.now());
		}
		
		
		theatreMoviesRepository.save(bkpTheartreMovies);
		
		return theatreMoviesDto;
	}


	@Override
	public List<TheatreMoviesDto> saveAllTheatreMovies(List<TheatreMoviesDto> theatreMoviesList) {
		List<BkpTheartreMovies> theatreMovieBkpList=new ArrayList<BkpTheartreMovies>();
		theatreMoviesList.forEach(theatreMoviesDto->{
		BkpTheartreMovies bkpTheartreMovies=new BkpTheartreMovies();
		Optional<BkpTheartreMovies> bkpTheartreMoviesGet = Optional.empty();
		Optional<BkpTheatre> bkpTheatreGet = Optional.empty();
		Optional<BkpMovies> bkpMoviesGet = Optional.empty();
		if(theatreMoviesDto.getId()!=null ) {
			bkpTheartreMoviesGet=theatreMoviesRepository.findById(theatreMoviesDto.getId());	
			}
		if(theatreMoviesDto.getTheatreId() !=null ) {
			 bkpTheatreGet=theatreRepository.findById(theatreMoviesDto.getTheatreId());	
			 bkpTheartreMovies.setTheatreIDD(bkpTheatreGet.get());
			
					}
		if(theatreMoviesDto.getMoviesId()!=null ) {
			 bkpMoviesGet=moviesRepository.findById(theatreMoviesDto.getMoviesId());	
			 
			 bkpTheartreMovies.setMovieIDD(bkpMoviesGet.get());	
			 if(theatreMoviesDto.getLanguages()!=null && theatreMoviesDto.getLanguages().size()>0)
				{
				 bkpTheartreMovies.setLanguages(getListOfMovieLanguages(theatreMoviesDto.getLanguages(),bkpMoviesGet.get().getLanguages()))	;		
				}
			
			}
			 	
		 
		bkpTheartreMovies.setActiveFlag(theatreMoviesDto.getActiveFlag());		
		bkpTheartreMovies.setModifiedBy(theatreMoviesDto.getModifiedBy());
		bkpTheartreMovies.setLastModifiedDate(LocalDateTime.now());
		
		if(bkpTheartreMoviesGet.isPresent()) {
			bkpTheartreMovies.setCreatedDate(bkpTheartreMoviesGet.get().getCreatedDate());
			bkpTheartreMovies.setCreatedBy(bkpTheartreMoviesGet.get().getCreatedBy());
			bkpTheartreMovies.setId(bkpTheartreMoviesGet.get().getId());
		}
		else {
			bkpTheartreMovies.setCreatedBy(theatreMoviesDto.getCreatedBy());
			bkpTheartreMovies.setCreatedDate(LocalDateTime.now());
		}
		
		theatreMovieBkpList.add(bkpTheartreMovies);
	});
		theatreMoviesRepository.saveAll(theatreMovieBkpList);
		
		
		return null;
	}


	@Override
	public List<TheatreMoviesDto> getAllTheatreMovies() {
		
		List<BkpTheartreMovies> bkpTheartreMovies=theatreMoviesRepository.findAll();
		List<TheatreMoviesDto> theatreMoviesList=new ArrayList<TheatreMoviesDto>();
		ModelMapper modelMapper = new ModelMapper();		
		bkpTheartreMovies.forEach(c->{
			TheatreMoviesDto theatreMovies=modelMapper.map(c,TheatreMoviesDto.class);
			theatreMovies.setLanguages(getListOfELanguages(c.getLanguages()));
			theatreMovies.setMovieName(c.getMovieIDD().getMovieName());
			theatreMovies.setMoviesId(c.getMovieIDD().getId());
			theatreMovies.setTheatreId(c.getTheatreIDD().getId());
			theatreMovies.setTheatreName(c.getTheatreIDD().getTheatreName());
			theatreMoviesList.add(theatreMovies);
			});
		return theatreMoviesList;
	}


	@Override
	public TheatreMoviesDto getTheatreMoviesById(UUID id) {
		Optional<BkpTheartreMovies> bkpTheartreMovies=theatreMoviesRepository.findById(id);
		TheatreMoviesDto theatreMovies=new TheatreMoviesDto();
		
		if(bkpTheartreMovies.isPresent()) {
		ModelMapper modelMapper = new ModelMapper();		
		
			theatreMovies=modelMapper.map(bkpTheartreMovies.get(),TheatreMoviesDto.class);
			theatreMovies.setLanguages(getListOfELanguages(bkpTheartreMovies.get().getLanguages()));
			theatreMovies.setMovieName(bkpTheartreMovies.get().getMovieIDD().getMovieName());
			theatreMovies.setMoviesId(bkpTheartreMovies.get().getMovieIDD().getId());
			theatreMovies.setTheatreId(bkpTheartreMovies.get().getTheatreIDD().getId());
			theatreMovies.setTheatreName(bkpTheartreMovies.get().getTheatreIDD().getTheatreName());
		}
		return theatreMovies;
	}
}
