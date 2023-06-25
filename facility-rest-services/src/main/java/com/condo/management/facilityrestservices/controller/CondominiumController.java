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

import com.condo.management.facilityrestservices.entity.Condominium;
import com.condo.management.facilityrestservices.request.CondominiumDto;
import com.condo.management.facilityrestservices.service.CondominiumService;

@RestController
public class CondominiumController {
	
	@Autowired
	private CondominiumService condominiumService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/v1/condominium/{id}")
	public CondominiumDto getCondominium (@PathVariable int id) throws Exception {
		Condominium condominium = condominiumService.getCondominium(id);
		CondominiumDto condominiumDto = modelMapper.map(condominium, CondominiumDto.class);
		return condominiumDto;
	}

	@PostMapping("/v1/condominium")
	public void createCondominium(@RequestBody CondominiumDto condominium) {
		condominiumService.createOrUpdateCondominium(modelMapper.map(condominium, Condominium.class));
	}

	@PutMapping("/v1/condominium")
	public void updateCondominium(@RequestBody Condominium condominium) {
		condominiumService.createOrUpdateCondominium(modelMapper.map(condominium, Condominium.class));
	}

	@DeleteMapping("/v1/condominium/{id}")
	public void deleteCondominium(@PathVariable int id) {
		condominiumService.deleteCondominium(id);
	}
}