package com.condo.management.facilityrestservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condo.management.facilityrestservices.entity.Condominium;
import com.condo.management.facilityrestservices.entity.Facility;
import com.condo.management.facilityrestservices.repository.FacilityRepository;

@Service
public class FacilityService {

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private CondominiumService condominiumService;

	public Facility getFacility(Integer id) throws Exception {
		Facility retrievedFacility = null;
		Optional<Facility> facility = facilityRepository.findById(id);
		if (facility.isPresent())
			retrievedFacility = facility.get();
		else
			throw new Exception("Facility does not exist");

		return retrievedFacility;
	}

	public void createOrUpdateFacility(Facility facility) throws Exception {
		boolean condoExists = false;
		if (facility.getCondominium().getId() != 0) {
			Condominium condo = condominiumService.getCondominium(facility.getCondominium().getId());
			if (condo != null && condo.getCondoName() != null)
				condoExists = true;

			if (condoExists)
				facilityRepository.save(facility);
		}

		if (!condoExists)
			throw new Exception("Condominium doesn't exist for the facility to be created");
	}

	public void deleteFacility(Integer id) {
		facilityRepository.deleteById(id);
	}
}
