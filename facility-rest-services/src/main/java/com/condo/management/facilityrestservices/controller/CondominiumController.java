package com.condo.management.facilityrestservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.condo.management.facilityrestservices.entity.Condominium;
import com.condo.management.facilityrestservices.service.CondominiumService;

@RestController
public class CondominiumController {
	
	@Autowired
	private CondominiumService condominiumService;

	@GetMapping("/v1/condominium/{id}")
	public Condominium getCondominium (@PathVariable int id) {
		return condominiumService.getCondominium(id);
	}

	@PostMapping("/v1/condominium")
	public void createCondominium(@RequestBody Condominium condominium) {
		condominiumService.createOrUpdateCondominium(condominium);
	}

	@PutMapping("/v1/condominium")
	public void updateCondominium(@RequestBody Condominium condominium) {
		condominiumService.createOrUpdateCondominium(condominium);
	}

	@DeleteMapping("/v1/condominium/{id}")
	public void deleteCondominium(@PathVariable int id) {
		condominiumService.deleteCondominium(id);
	}
}