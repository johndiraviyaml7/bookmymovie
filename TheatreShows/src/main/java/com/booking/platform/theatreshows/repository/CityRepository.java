package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpCity;


@Repository
public interface CityRepository extends JpaRepository<BkpCity, Long> {
	 
	public List<BkpCity> findByActiveFlag(String activeFlag);
	public List<BkpCity> findByCountry(UUID countryId);
	
	public Optional<BkpCity> findById(UUID id);
}
