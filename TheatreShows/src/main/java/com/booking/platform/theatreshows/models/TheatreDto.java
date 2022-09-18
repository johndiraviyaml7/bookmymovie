package com.booking.platform.theatreshows.models;

import java.io.Serializable;
import java.util.UUID;

public class TheatreDto extends BaseModelDto implements Serializable  {
	
	private static final long serialVersionUID= 1L;

	public TheatreDto() {
		// TODO Auto-generated constructor stub
	}

	
	private String theatreName;	
	private UUID cityId;

	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public UUID getCityId() {
		return cityId;
	}
	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}

	
	
	
}
