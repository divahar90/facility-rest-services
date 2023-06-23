package com.condo.management.facilityrestservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.condo.management.facilityrestservices.entity.FacilityUser;
import com.condo.management.facilityrestservices.service.FacilityUserService;

@RestController
public class UserController {

	@Autowired
	private FacilityUserService userService;

	@GetMapping("/v1/user/{id}")
	public FacilityUser getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@PostMapping("/v1/user")
	public void createUser(@RequestBody FacilityUser user) {
		userService.createOrUpdateUser(user);
	}

	@PutMapping("/v1/user")
	public void updateUser(@RequestBody FacilityUser user) {
		userService.createOrUpdateUser(user);
	}

	@DeleteMapping("/v1/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}