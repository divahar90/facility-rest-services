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

import com.condo.management.facilityrestservices.entity.FacilityUser;
import com.condo.management.facilityrestservices.request.FacilityUserDto;
import com.condo.management.facilityrestservices.service.FacilityUserService;

@RestController
public class UserController {

	@Autowired
	private FacilityUserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/v1/user/{id}")
	public FacilityUserDto getUser(@PathVariable int id) throws Exception {
		FacilityUser facilityUser = userService.getUser(id);
		FacilityUserDto facilityUserDto = modelMapper.map(facilityUser, FacilityUserDto.class);
		return facilityUserDto;
	}

	@PostMapping("/v1/user")
	public void createUser(@RequestBody FacilityUserDto user) {
		userService.createOrUpdateUser(modelMapper.map(user, FacilityUser.class));
	}

	@PutMapping("/v1/user")
	public void updateUser(@RequestBody FacilityUserDto user) {
		userService.createOrUpdateUser(modelMapper.map(user, FacilityUser.class));
	}

	@DeleteMapping("/v1/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}