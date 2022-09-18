package com.booking.platform.theatreshows.models;

import java.io.Serializable;
import java.util.UUID;

public class CountryDto extends BaseModelDto implements Serializable  {
	
	private static final long serialVersionUID= 1L;

	public CountryDto() {
		// TODO Auto-generated constructor stub
	}

	
	private String countryName;	
	private String countryCode;


	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	
}
