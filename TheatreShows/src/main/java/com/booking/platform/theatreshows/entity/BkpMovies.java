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
@Table(	name = "bkp_movies" )
	public class BkpMovies extends BaseCrudEntityModify<Long> implements Serializable {
		private static final long serialVersionUID= 1;
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		private UUID id;

		@NotNull
		@Size(max = 100)
		@Column(name="movie_name")
		private String movieName;
		
		
		@NotNull
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "bkp_movie_languages", 
					joinColumns = @JoinColumn(name = "movie_id"), 
					inverseJoinColumns = @JoinColumn(name = "language_id"))		
		private Set<BkpLanguages> languages = new HashSet<>();  
		
		@NotNull
		@Column(name="release_date")
		private LocalDateTime releaseDate;
		
		@NotNull
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "bkp_movie_genre", 
					joinColumns = @JoinColumn(name = "movie_id"), 
					inverseJoinColumns = @JoinColumn(name = "genere_id"))		
		private Set<BkpGenre> bkpGenre = new HashSet<>();  
		
		@Column(name="synopsis")
		private String synopsis;
		
		@Column(name="crew_details")
		private String crewDetails;	
		
		
	

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		 

		public Set<BkpLanguages> getLanguages() {
			return languages;
		}

		public void setLanguages(Set<BkpLanguages> languages) {
			this.languages = languages;
		}

		public LocalDateTime getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(LocalDateTime releaseDate) {
			this.releaseDate = releaseDate;
		}
		

		public Set<BkpGenre> getBkpGenre() {
			return bkpGenre;
		}

		public void setBkpGenre(Set<BkpGenre> bkpGenre) {
			this.bkpGenre = bkpGenre;
		}

		public String getSynopsis() {
			return synopsis;
		}

		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}

		public String getCrewDetails() {
			return crewDetails;
		}

		public void setCrewDetails(String crewDetails) {
			this.crewDetails = crewDetails;
		}		

		
}
