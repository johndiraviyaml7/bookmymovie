package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpTheatre;


@Repository
public interface TheatreRepository extends JpaRepository<BkpTheatre, Long> {
	public List<BkpTheatre> findByActiveFlag(String activeFlag);
	public List<BkpTheatre> findByCity(UUID cityId);
	public Optional<BkpTheatre> findById(UUID id);
}
