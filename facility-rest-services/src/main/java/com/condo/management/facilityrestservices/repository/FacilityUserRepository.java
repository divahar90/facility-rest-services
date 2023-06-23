package com.condo.management.facilityrestservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condo.management.facilityrestservices.entity.FacilityUser;

@Repository
public interface FacilityUserRepository extends JpaRepository<FacilityUser, Integer> {

}