package com.condo.management.facilityrestservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condo.management.facilityrestservices.entity.Condominium;
import com.condo.management.facilityrestservices.repository.CondominiumRepository;

@Service
public class CondominiumService {

	@Autowired
	private CondominiumRepository condominiumRepository;

	public Condominium getCondominium(Integer id) {
		Condominium retrievedCondo = null;
		Optional<Condominium> condo = condominiumRepository.findById(id);
		if (condo.isPresent())
			retrievedCondo = condo.get();

		return retrievedCondo;
	}

	public void createOrUpdateCondominium(Condominium condominium) {
		condominiumRepository.save(condominium);
	}

	public void deleteCondominium(Integer id) {
		condominiumRepository.deleteById(id);
	}
}
