package com.condo.management.facilityrestservices.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.condo.management.facilityrestservices.entity.Booking;
import com.condo.management.facilityrestservices.entity.Facility;
import com.condo.management.facilityrestservices.entity.FacilityUser;
import com.condo.management.facilityrestservices.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
	
	@Mock
	private BookingRepository bookingRepository;

	@InjectMocks
	private BookingService bookingService;

	private Booking booking;
	
	@BeforeEach
	public void setup() {
		booking = new Booking(1, LocalDateTime.now(), LocalDateTime.now().plusHours(1), 2, new Facility(), new FacilityUser());
	}
	
    @DisplayName("Get booking based on valid booking Id")
    @Test
    public void getBooking_Success(){
        when(bookingRepository.findById(1))
                .thenReturn(Optional.of(booking));
        assertNotNull(bookingService.getBooking(1));
        
    }

    @DisplayName("Get booking when no booking Id exists")
    @Test
    public void getBooking_NoResults(){
        when(bookingRepository.findById(2))
                .thenReturn(Optional.empty());
        assertThat(bookingService.getBooking(2)).isNull();
        
    }
}
