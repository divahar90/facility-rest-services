package com.condo.management.facilityrestservices.request;

import java.util.Set;

import jakarta.validation.constraints.Size;

public class CondominiumDto {

	private Integer id;

	@Size(min = 5, message = "Condominium name should have atleast 5 characters")
	private String condoName;
	
	@Size(min = 5, message = "Street name should have atleast 5 characters")
	private String streetName;
	
	@Size(min = 2, max = 5, message = "Street number should be between 2 and 5 characters")
	private String streetNumber;
	
	@Size(min = 5, message = "City name should have atleast 5 characters")
	private String city;
	
	@Size(min = 6, max = 6, message = "Postal code should have exactly 6 characters")
	private String postalCode;
	
	private int condominiumId;
	
	private Set<FacilityDto> facilities;
	
	public CondominiumDto() {
		super();
	}

	public CondominiumDto(Integer id,
			@Size(min = 5, message = "Condominium name should have atleast 5 characters") String condoName,
			@Size(min = 5, message = "Street name should have atleast 5 characters") String streetName,
			@Size(min = 2, max = 5, message = "Street number should be between 2 and 5 characters") String streetNumber,
			@Size(min = 5, message = "City name should have atleast 5 characters") String city,
			@Size(min = 6, max = 6, message = "Postal code should have exactly 6 characters") String postalCode,
			int condominiumId, Set<FacilityDto> facilities) {
		super();
		this.id = id;
		this.condoName = condoName;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.condominiumId = condominiumId;
		this.facilities = facilities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCondoName() {
		return condoName;
	}

	public void setCondoName(String condoName) {
		this.condoName = condoName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getCondominiumId() {
		return condominiumId;
	}

	public void setCondominiumId(int condominiumId) {
		this.condominiumId = condominiumId;
	}

	public Set<FacilityDto> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<FacilityDto> facilities) {
		this.facilities = facilities;
	}

}
