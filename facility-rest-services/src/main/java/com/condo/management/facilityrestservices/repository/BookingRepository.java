package com.condo.management.facilityrestservices.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.condo.management.facilityrestservices.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	@Query(nativeQuery = true, value="select sum(no_of_pax) from t_booking where from_dt_time = :fromDtTime and to_dt_time = :toDtTime and facility_id = :facilityId")
	Integer getTotalPaxPerSlotAndFacility(@Param("fromDtTime") LocalDateTime fromDtTime,
			@Param("toDtTime") LocalDateTime toDtTime, @Param("facilityId") int facilityId);
	
}