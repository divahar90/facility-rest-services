package com.condo.management.facilityrestservices.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity(name = "T_CONDOMINIUM")
public class Condominium {

	@Id
	@GeneratedValue
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
	
	@OneToMany(mappedBy = "condominium", cascade = CascadeType.ALL)
	private Set<Facility> facilities = new HashSet<>();
	
	@OneToMany(mappedBy = "condominium", cascade = CascadeType.ALL)
	private Set<FacilityUser> facilityUsers = new HashSet<>();
	
	public Condominium() {
		super();
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

	public Set<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}
}
