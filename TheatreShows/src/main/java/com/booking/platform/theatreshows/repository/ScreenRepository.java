package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpScreen;


@Repository
public interface ScreenRepository extends JpaRepository<BkpScreen, Long> {

	public List<BkpScreen> findByActiveFlag(String activeFlag);
	public List<BkpScreen> findByTheatre(UUID theatreId);
	public Optional<BkpScreen> findById(UUID id);
}
