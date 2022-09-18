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
@Table(	name = "bkp_Theatre" )
	public class BkpTheatre extends BaseCrudEntityModify<Long> implements Serializable {
		private static final long serialVersionUID= 1;
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		private UUID id;

		@NotNull
		@Size(max = 100)
		@Column(name="theatre_name")
		private String theatreName;
		
		@OneToOne(fetch = FetchType.LAZY)	
		@JoinColumn(name = "city_id")
		private BkpCity city; 
		
	

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getTheatreName() {
			return theatreName;
		}

		public void setTheatreName(String theatreName) {
			this.theatreName = theatreName;
		}

		public BkpCity getCity() {
			return city;
		}

		public void setCity(BkpCity city) {
			this.city = city;
		}

		


		
	


		
		
		
}
