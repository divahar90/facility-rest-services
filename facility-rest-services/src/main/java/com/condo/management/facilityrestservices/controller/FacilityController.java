package com.condo.management.facilityrestservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.condo.management.facilityrestservices.entity.Facility;
import com.condo.management.facilityrestservices.service.FacilityService;

@RestController
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@GetMapping("/v1/facility/{id}")
	public Facility getFaciltity(@PathVariable int id) {
		return facilityService.getFacility(id);
	}

	@PostMapping("/v1/facility")
	public void createUser(@RequestBody Facility facility) throws Exception {
		facilityService.createOrUpdateFacility(facility);
	}

	@PutMapping("/v1/facility")
	public void updateCondominium(@RequestBody Facility facility) throws Exception {
		facilityService.createOrUpdateFacility(facility);
	}

	@DeleteMapping("/v1/facility/{id}")
	public void deleteCondominium(@PathVariable int id) {
		facilityService.deleteFacility(id);
	}
}