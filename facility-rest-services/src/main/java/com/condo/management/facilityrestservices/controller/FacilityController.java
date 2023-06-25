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

import com.condo.management.facilityrestservices.entity.Facility;
import com.condo.management.facilityrestservices.request.FacilityDto;
import com.condo.management.facilityrestservices.service.FacilityService;

@RestController
public class FacilityController {

	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/v1/facility/{id}")
	public FacilityDto getFaciltity(@PathVariable int id) throws Exception {
		Facility facility = facilityService.getFacility(id);
		FacilityDto facilityDto = modelMapper.map(facility, FacilityDto.class);
		return facilityDto;
	}

	@PostMapping("/v1/facility")
	public void createUser(@RequestBody FacilityDto facility) throws Exception {
		facilityService.createOrUpdateFacility(modelMapper.map(facility, Facility.class));
	}

	@PutMapping("/v1/facility")
	public void updateCondominium(@RequestBody FacilityDto facility) throws Exception {
		facilityService.createOrUpdateFacility(modelMapper.map(facility, Facility.class));
	}

	@DeleteMapping("/v1/facility/{id}")
	public void deleteCondominium(@PathVariable int id) {
		facilityService.deleteFacility(id);
	}
}