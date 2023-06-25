package com.condo.management.facilityrestservices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.condo.management.facilityrestservices.entity.Booking;
import com.condo.management.facilityrestservices.request.BookingDto;
import com.condo.management.facilityrestservices.service.BookingService;

import jakarta.validation.Valid;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/v1/booking/{id}")
	public BookingDto getFaciltity(@PathVariable int id) {
		Booking booking = bookingService.getBooking(id);
		BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
		return bookingDto;
	}

	@PostMapping("/v1/booking")
	public void createUser(@Valid @RequestBody BookingDto booking) throws Exception {
		bookingService.createOrUpdateBooking(modelMapper.map(booking, Booking.class));
	}

	@PutMapping("/v1/booking")
	public void updateCondominium(@Valid @RequestBody BookingDto booking) throws Exception {
		bookingService.createOrUpdateBooking(modelMapper.map(booking, Booking.class));
	}

	@DeleteMapping("/v1/booking/{id}")
	public void deleteCondominium(@PathVariable int id) {
		bookingService.deleteBooking(id);
	}
}