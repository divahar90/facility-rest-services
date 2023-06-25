package com.condo.management.facilityrestservices.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "T_FACILITY_USER")
public class FacilityUser {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Size(min = 4, message = "Unit number should have atleast 2 characters")
	private String unitNumber;
	
	@Past(message = "Move in Date should be in the past")
	private LocalDate moveInDate;

	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Condominium condominium;
	
	@OneToMany(mappedBy = "facilityUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Booking> bookings = new HashSet<>();
	
	public FacilityUser() {
		super();
	}

	public FacilityUser(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Size(min = 4, message = "Unit number should have atleast 2 characters") String unitNumber,
			@Past(message = "Move in Date should be in the past") LocalDate moveInDate,
			@Past(message = "Birth Date should be in the past") LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.unitNumber = unitNumber;
		this.moveInDate = moveInDate;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public LocalDate getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(LocalDate moveInDate) {
		this.moveInDate = moveInDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Condominium getCondominium() {
		return condominium;
	}

	public void setCondominium(Condominium condominium) {
		this.condominium = condominium;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
}
