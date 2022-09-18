package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpGenre;
import com.booking.platform.theatreshows.entity.EGenre;


@Repository
public interface GenreRepository extends JpaRepository<BkpGenre, Long> {
	 
	public List<BkpGenre> findByActiveFlag(String activeFlag);	
	public Optional<BkpGenre> findById(UUID id);
	public Optional<BkpGenre> findByGenreName(EGenre genre);
}
