package com.condo.management.facilityrestservices.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class FacilityUserDto {

	private Integer id;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Size(min = 4, message = "Unit number should have atleast 2 characters")
	private String unitNumber;
	
	@Past(message = "Move in Date should be in the past")
	private LocalDate moveInDate;

	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;
	
	private CondominiumDto condominium;
	
	private List<BookingDto> bookings;

	public FacilityUserDto() {
		super();
	}
	
	public FacilityUserDto(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Size(min = 4, message = "Unit number should have atleast 2 characters") String unitNumber,
			@Past(message = "Move in Date should be in the past") LocalDate moveInDate,
			@Past(message = "Birth Date should be in the past") LocalDate birthDate, CondominiumDto condominium,
			List<BookingDto> bookings) {
		super();
		this.id = id;
		this.name = name;
		this.unitNumber = unitNumber;
		this.moveInDate = moveInDate;
		this.birthDate = birthDate;
		this.condominium = condominium;
		this.bookings = bookings;
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

	public CondominiumDto getCondominium() {
		return condominium;
	}

	public void setCondominium(CondominiumDto condominium) {
		this.condominium = condominium;
	}

	public List<BookingDto> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDto> bookings) {
		this.bookings = bookings;
	}
	
}
