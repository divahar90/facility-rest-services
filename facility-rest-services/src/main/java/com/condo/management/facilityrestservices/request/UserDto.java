package com.condo.management.facilityrestservices.request;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class UserDto {

	private Integer id;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;

	@Email
	private String email;

	@NotBlank
	private String role;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@JsonProperty(access = Access.READ_ONLY)
	private String accessToken;

	@Size(min = 4, message = "Unit number should have atleast 2 characters")
	private String unitNumber;

	@Past(message = "Move in Date should be in the past")
	private LocalDate moveInDate;

	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;

	private CondominiumDto condominium;

	private List<BookingDto> bookings;

	public UserDto() {
		super();
	}

	public UserDto(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Email String email, @NotBlank String role, String password, String accessToken,
			@Size(min = 4, message = "Unit number should have atleast 2 characters") String unitNumber,
			@Past(message = "Move in Date should be in the past") LocalDate moveInDate,
			@Past(message = "Birth Date should be in the past") LocalDate birthDate, CondominiumDto condominium,
			List<BookingDto> bookings) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.accessToken = accessToken;
		this.unitNumber = unitNumber;
		this.moveInDate = moveInDate;
		this.birthDate = birthDate;
		this.condominium = condominium;
		this.bookings = bookings;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
