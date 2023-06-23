package com.condo.management.facilityrestservices.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.condo.management.facilityrestservices.entity.FacilityUser;
import com.condo.management.facilityrestservices.repository.FacilityUserRepository;

@Service
public class FacilityUserService {

	private FacilityUserRepository userRepository;

	public FacilityUserService(FacilityUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public FacilityUser getUser(Integer id) {
		FacilityUser retrievedUser = null;
		Optional<FacilityUser> user = userRepository.findById(id);
		if (user.isPresent())
			retrievedUser = user.get();

		return retrievedUser;
	}

	public void createOrUpdateUser(FacilityUser user) {
		userRepository.save(user);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}
