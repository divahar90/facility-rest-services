package com.condo.management.facilityrestservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condo.management.facilityrestservices.entity.Booking;
import com.condo.management.facilityrestservices.entity.Facility;
import com.condo.management.facilityrestservices.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private FacilityService facilityService;

	public Booking getBooking(Integer id) {
		Booking retrievedBooking = null;
		Optional<Booking> booking = bookingRepository.findById(id);
		if (booking.isPresent())
			retrievedBooking = booking.get();

		return retrievedBooking;
	}

	public void createOrUpdateBooking(Booking booking) throws Exception {
		int maxCapacity = checkFacilityExists(booking);
		checkSlotsExists(booking, maxCapacity);
		bookingRepository.save(booking);

	}
	
	private void checkSlotsExists(Booking booking, int maxCapacity) throws Exception {
		Integer totalBooked = bookingRepository.getTotalPaxPerSlotAndFacility(booking.getFromDtTime(), booking.getToDtTime(), booking.getFacility().getId());
		totalBooked = totalBooked == null ? 0 : totalBooked;
		if ((maxCapacity - totalBooked) < booking.getNoOfPax())
			throw new Exception("Booking capacity exceeded, please try new slots");
	}

	private int checkFacilityExists(Booking booking) throws Exception {
		boolean facilityExists = false;
		Facility facility = null;
		if (booking.getFacility().getId() != 0) {
			facility = facilityService.getFacility(booking.getFacility().getId());
			if (facility != null && facility.getFacilityName() != null)
				facilityExists = true;
		}

		if (!facilityExists)
			throw new Exception("Facility doesn't exist for the booking to be created");
		
		return facility.getMaxCapacity();
	}

	public void deleteBooking(Integer id) {
		bookingRepository.deleteById(id);
	}
}
