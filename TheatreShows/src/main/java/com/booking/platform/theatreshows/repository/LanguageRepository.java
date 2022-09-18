package com.booking.platform.theatreshows.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.theatreshows.entity.BkpCountry;
import com.booking.platform.theatreshows.entity.BkpLanguages;
import com.booking.platform.theatreshows.entity.ELanguages;


@Repository
public interface LanguageRepository extends JpaRepository<BkpLanguages, Long> {
	 
	public List<BkpLanguages> findByActiveFlag(String activeFlag);	
	public Optional<BkpLanguages> findById(UUID id);
	public Optional<BkpLanguages> findByLanguage(ELanguages language);
}
