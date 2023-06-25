package com.condo.management.facilityrestservices.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;

public class BookingDto {
	
	private Integer id;

	@Future(message = "From Date should be in the future")
	private LocalDateTime fromDtTime;
	
	@Future(message = "Move in Date should be in the future")
	private LocalDateTime toDtTime;
	
	@Min(value = 1, message = "Minimum number of pax should be 1")
	private int noOfPax;
	
	private FacilityDto facility;
	
	private FacilityUserDto facilityUser;
	
	public BookingDto() {
		super();
	}
	
	public BookingDto(Integer id, @Future(message = "From Date should be in the future") LocalDateTime fromDtTime,
			@Future(message = "Move in Date should be in the future") LocalDateTime toDtTime,
			@Min(value = 1, message = "Minimum number of pax should be 1") int noOfPax, FacilityDto facility,
			FacilityUserDto facilityUser) {
		super();
		this.id = id;
		this.fromDtTime = fromDtTime;
		this.toDtTime = toDtTime;
		this.noOfPax = noOfPax;
		this.facility = facility;
		this.facilityUser = facilityUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFromDtTime() {
		return fromDtTime;
	}

	public void setFromDtTime(LocalDateTime fromDtTime) {
		this.fromDtTime = fromDtTime;
	}

	public LocalDateTime getToDtTime() {
		return toDtTime;
	}

	public void setToDtTime(LocalDateTime toDtTime) {
		this.toDtTime = toDtTime;
	}

	public int getNoOfPax() {
		return noOfPax;
	}

	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	public FacilityDto getFacility() {
		return facility;
	}

	public void setFacility(FacilityDto facility) {
		this.facility = facility;
	}

	public FacilityUserDto getFacilityUser() {
		return facilityUser;
	}

	public void setFacilityUser(FacilityUserDto facilityUser) {
		this.facilityUser = facilityUser;
	}
	
	
}
