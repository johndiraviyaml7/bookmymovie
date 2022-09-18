package com.booking.platform.theatreshows.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;



@Entity
@Table(	name = "bkp_theatre_movies" )
	public class BkpTheartreMovies extends BaseCrudEntityModify<Long> implements Serializable {
		private static final long serialVersionUID= 1;
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		private UUID id;

		@NotNull
		@OneToOne(fetch = FetchType.LAZY)	
		@JoinColumn(name="movie_id")
		private BkpMovies movieIDD;
		
		@NotNull
		@OneToOne(fetch = FetchType.LAZY)	
		@JoinColumn(name="theatre_id")
		private BkpTheatre theatreIDD;
		
		@NotNull
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "bkp_movie_theatre_languages", 
					joinColumns = @JoinColumn(name = "movie_theatre_id"), 
					inverseJoinColumns = @JoinColumn(name = "language_id"))		
		private Set<BkpLanguages> languages = new HashSet<>();  

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public BkpMovies getMovieIDD() {
			return movieIDD;
		}

		public void setMovieIDD(BkpMovies movieIDD) {
			this.movieIDD = movieIDD;
		}

		public BkpTheatre getTheatreIDD() {
			return theatreIDD;
		}

		public void setTheatreIDD(BkpTheatre theatreIDD) {
			this.theatreIDD = theatreIDD;
		}

		public Set<BkpLanguages> getLanguages() {
			return languages;
		}

		public void setLanguages(Set<BkpLanguages> languages) {
			this.languages = languages;
		}

		@Override
		public String toString() {
			return "BkpTheartreMovies [id=" + id + ", movieIDD=" + movieIDD.getMovieName() + ", theatreIDD=" + theatreIDD.getTheatreName()
					+ ", languages=" + languages.toString().toString() + ", getId()=" + getId() + ", getMovieIDD()=" + getMovieIDD()
					+ ", getTheatreIDD()=" + getTheatreIDD() + ", getLanguages()=" + getLanguages()
					+ ", getCreatedDate()=" + getCreatedDate() + ", getLastModifiedDate()=" + getLastModifiedDate()
					+ ", getCreatedBy()=" + getCreatedBy() + ", getModifiedBy()=" + getModifiedBy()
					+ ", getActiveFlag()=" + getActiveFlag() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		

		
}
