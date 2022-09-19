package com.booking.platform.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.booking.model.BookingShows;


@Repository
public interface BookingShowsRepository extends MongoRepository<BookingShows, Long>{

}
