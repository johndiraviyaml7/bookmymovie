package com.booking.platform.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class BookingSeats {

	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private Long seatId;
	private String seatName;
	private ESeatStatus seatStatus;
	
	public BookingSeats() {
		
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public ESeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(ESeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}
	
}
