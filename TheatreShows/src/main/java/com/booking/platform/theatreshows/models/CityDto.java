package com.booking.platform.theatreshows.models;

import java.io.Serializable;
import java.util.UUID;

public class CityDto extends BaseModelDto implements Serializable  {
	
	private static final long serialVersionUID= 1L;

	public CityDto() {
		// TODO Auto-generated constructor stub
	}

	
	private String cityName;	
	private UUID countryId;

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public UUID getCountryId() {
		return countryId;
	}
	public void setCountryId(UUID countryId) {
		this.countryId = countryId;
	}
	
	
	
}
