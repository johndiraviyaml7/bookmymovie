package com.booking.platform.theatreshows.models;

import java.io.Serializable;
import java.util.UUID;

public class ScreenDto extends BaseModelDto implements Serializable  {
	
	private static final long serialVersionUID= 1L;

	public ScreenDto() {
		// TODO Auto-generated constructor stub
	}

	
	private String screenName;	
	private UUID theatreId;
	private int totalSeats;

	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public UUID getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(UUID theatreId) {
		this.theatreId = theatreId;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

		
}
