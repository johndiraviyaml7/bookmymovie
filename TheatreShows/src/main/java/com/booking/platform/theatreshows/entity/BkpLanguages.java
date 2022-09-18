package com.booking.platform.theatreshows.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(	name = "bkp_languages" )
	public class BkpLanguages extends BaseCrudEntityModify<Long> implements Serializable {
		private static final long serialVersionUID= 1;
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		private UUID id;

		@Enumerated(EnumType.STRING)
		@Size(max = 20)
		@Column(name="language")
		private ELanguages language;

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public ELanguages getLanguage() {
			return language;
		}

		public void setLanguage(ELanguages language) {
			this.language = language;
		}
		
		
		
}
