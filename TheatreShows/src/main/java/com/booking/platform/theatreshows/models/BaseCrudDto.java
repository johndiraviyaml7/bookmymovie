package com.booking.platform.theatreshows.models;

import java.time.LocalDateTime;
import java.util.UUID;
import java.io.Serializable;

public abstract class BaseCrudDto implements Serializable {
	
	private static final long serialVersionUID= 1L;

	private UUID id;
	private String activeFlag; 
	private LocalDateTime createdDate;	
	private LocalDateTime LastModifiedDate;	
	private String createdBy;	
	private String modifiedBy;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getLastModifiedDate() {
		return LastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	

}
