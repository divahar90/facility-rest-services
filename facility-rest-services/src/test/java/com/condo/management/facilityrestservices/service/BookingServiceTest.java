package com.condo.management.facilityrestservices.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.condo.management.facilityrestservices.entity.Booking;
import com.condo.management.facilityrestservices.entity.Facility;
import com.condo.management.facilityrestservices.entity.FacilityUser;
import com.condo.management.facilityrestservices.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

	@Mock
	private BookingRepository bookingRepository;

	@Mock
	private FacilityService facilityService;

	@InjectMocks
	private BookingService bookingService;

	private Booking booking;

	@BeforeEach
	public void setup() {
		Facility facility = new Facility();
		facility.setId(1);
		facility.setMaxCapacity(25);
		facility.setFacilityName("FacilityA");
		booking = new Booking(1, LocalDateTime.now(), LocalDateTime.now().plusHours(1), 2, facility,
				new FacilityUser());
	}

	@DisplayName("Get booking based on valid booking Id")
    @Test
    public void getBookingTest (){
        when(bookingRepository.findById(1))
                .thenReturn(Optional.of(booking));
        assertNotNull(bookingService.getBooking(1));
        
    }

	@DisplayName("Get booking when no booking Id exists")
    @Test
    public void noBookingExistsTest (){
        when(bookingRepository.findById(2))
                .thenReturn(Optional.empty());
        assertThat(bookingService.getBooking(2)).isNull();
        
    }

	@DisplayName("Create booking based on details through input")
    @Test
    public void createBookingTest () throws Exception{
        when(facilityService.getFacility(booking.getFacility().getId()))
                .thenReturn(booking.getFacility());
        when(bookingRepository.save(booking))
        .thenReturn(booking);
        when(bookingRepository.getTotalPaxPerSlotAndFacility(booking.getFromDtTime(), booking.getToDtTime(), booking.getFacility().getId()))
        .thenReturn(0);
        Method method1 = BookingService.class.getDeclaredMethod("checkFacilityExists", Booking.class);
        method1.setAccessible(true);
        Method method2 = BookingService.class.getDeclaredMethod("checkSlotsExists", Booking.class, Integer.class);
        method2.setAccessible(true);
        method2.invoke(bookingService, booking, method1.invoke(bookingService, booking));
        bookingService.createOrUpdateBooking(booking);
        Mockito.verify(bookingRepository, times(1)).save(booking);
    }

	@DisplayName("Create booking based on details through input when booking capacity exceeds")
    @Test
    public void createBookingCapacityExceededTest () throws Exception{
        when(facilityService.getFacility(booking.getFacility().getId()))
                .thenReturn(booking.getFacility());
        when(bookingRepository.getTotalPaxPerSlotAndFacility(booking.getFromDtTime(), booking.getToDtTime(), booking.getFacility().getId()))
        .thenReturn(25);
        Method method1 = BookingService.class.getDeclaredMethod("checkFacilityExists", Booking.class);
        method1.setAccessible(true);
        Method method2 = BookingService.class.getDeclaredMethod("checkSlotsExists", Booking.class, Integer.class);
        method2.setAccessible(true);
        Throwable exception = assertThrows(Exception.class, () ->  bookingService.createOrUpdateBooking(booking));
        assertEquals("Booking capacity exceeded, please try new slots", exception.getMessage());
    }

	@DisplayName("Create booking based on details through input when facility does not exist")
    @Test
    public void createBookingNoFacilityTest () throws Exception{
        when(facilityService.getFacility(booking.getFacility().getId()))
                .thenReturn(null);
        Method method1 = BookingService.class.getDeclaredMethod("checkFacilityExists", Booking.class);
        method1.setAccessible(true);
        Throwable exception = assertThrows(Exception.class, () ->  bookingService.createOrUpdateBooking(booking));
        assertEquals("Facility doesn't exist for the booking to be created", exception.getMessage());
    }

	@DisplayName("Deleting booking through ID")
	@Test
	public void deleteBookingTest() throws Exception {
		Mockito.doNothing().when(bookingRepository).deleteById(booking.getId());
		bookingService.deleteBooking(booking.getId());
		Mockito.verify(bookingRepository, times(1)).deleteById(booking.getId());
	}
}
