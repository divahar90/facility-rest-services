package com.condo.management.facilityrestservices.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "T_BOOKING")
public class Booking {

	@Id
	@GeneratedValue
	private Integer id;

	private LocalDateTime fromDtTime;
	
	private LocalDateTime toDtTime;
	
	private int noOfPax;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User facilityUser;
	
	public Booking() {
		super();
	}

	public Booking(Integer id, LocalDateTime fromDtTime, LocalDateTime toDtTime, int noOfPax, Facility facility,
			User facilityUser) {
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public User getFacilityUser() {
		return facilityUser;
	}

	public void setFacilityUser(User facilityUser) {
		this.facilityUser = facilityUser;
	}
}
