package com.booking.platform.theatreshows.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(	name = "bkp_city" )
	public class BkpCity extends BaseCrudEntityModify<Long> implements Serializable {
		private static final long serialVersionUID= 1;
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		private UUID id;

		@NotNull
		@Size(max = 100)
		@Column(name="city_name")
		private String cityName;
		
		@OneToOne(fetch = FetchType.LAZY)	
		@JoinColumn(name = "country_id")
		private BkpCountry country; 
		
	

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public BkpCountry getCountry() {
			return country;
		}

		public void setCountry(BkpCountry country) {
			this.country = country;
		}

		
	


		
		
		
}
