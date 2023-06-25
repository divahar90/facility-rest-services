package com.condo.management.facilityrestservices.request;

import jakarta.validation.constraints.Size;

public class FacilityDto {

	private Integer id;

	@Size(min = 2, message = "Name should have atleast 5 characters")
	private String facilityName;
	
	private int maxCapacity;
	
	private boolean isOpen;
	
	private int condominiumId;
	
	public FacilityDto() {
		super();
	}

	public FacilityDto(Integer id,
			@Size(min = 2, message = "Name should have atleast 5 characters") String facilityName, int maxCapacity,
			boolean isOpen, int condominiumId) {
		super();
		this.id = id;
		this.facilityName = facilityName;
		this.maxCapacity = maxCapacity;
		this.isOpen = isOpen;
		this.condominiumId = condominiumId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getCondominiumId() {
		return condominiumId;
	}

	public void setCondominiumId(int condominiumId) {
		this.condominiumId = condominiumId;
	}
	
}
