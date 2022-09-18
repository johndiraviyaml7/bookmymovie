package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpGenre;
import com.booking.platform.theatreshows.entity.BkpMovies;


@Repository
public interface MoviesRepository extends JpaRepository<BkpMovies, Long> {
	public List<BkpMovies> findByActiveFlag(String activeFlag);
	public Optional<BkpMovies> findByMovieName(String movieName); 
	public Optional<BkpMovies> findById(UUID id);
}
