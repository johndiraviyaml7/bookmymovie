package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpTheartreMovies;


@Repository
public interface TheatreMoviesRepository extends JpaRepository<BkpTheartreMovies, Long> {
	public List<BkpTheartreMovies> findByActiveFlag(String activeFlag);
	 
	public Optional<BkpTheartreMovies> findById(UUID id);
}
