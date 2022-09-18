package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpCountry;


@Repository
public interface CountryRepository extends JpaRepository<BkpCountry, Long> {
	 
	public List<BkpCountry> findByActiveFlag(String activeFlag);
	
	public Optional<BkpCountry> findById(UUID id);
}
