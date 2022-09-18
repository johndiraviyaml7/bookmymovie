package com.booking.platform.theatreshows.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(	name = "bkp_Country" )
	public class BkpCountry extends BaseCrudEntityModify<Long> implements Serializable {
		private static final long serialVersionUID= 1;
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		
		private UUID id;

		@NotNull
		@Size(max = 100)
		@Column(name="country_name")
		private String countryName;
		
		@NotNull
		@Size(max = 3)
		@Column(name="country_code")
		private String countryCode;

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

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

		@Override
		public String toString() {
			return "BkpCountry [id=" + id + ", countryName=" + countryName + ", countryCode=" + countryCode
					+ ", getCreatedDate()=" + getCreatedDate() + ", getLastModifiedDate()=" + getLastModifiedDate()
					+ ", getCreatedBy()=" + getCreatedBy() + ", getModifiedBy()=" + getModifiedBy()
					+ ", getActiveFlag()=" + getActiveFlag() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}

		
		
		
}
