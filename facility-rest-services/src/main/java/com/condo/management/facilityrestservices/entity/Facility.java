package com.condo.management.facilityrestservices.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity(name = "T_FACILITY")
public class Facility {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should have atleast 5 characters")
	private String facilityName;
	
	private int maxCapacity;
	
	private boolean isOpen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Condominium condominium;
	
	@OneToMany(mappedBy = "facility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Booking> bookings = new HashSet<>();
	
	public Facility() {
		super();
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

	public Condominium getCondominium() {
		return condominium;
	}

	public void setCondominium(Condominium condominium) {
		this.condominium = condominium;
	}
	
}
