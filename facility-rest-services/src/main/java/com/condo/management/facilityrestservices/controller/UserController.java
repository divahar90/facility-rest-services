package com.condo.management.facilityrestservices.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/v1/user")
	public String getUser() {
		return "user";
	}

	@PostMapping("/v1/user")
	public void createUser() {
	}

	@PutMapping("/v1/user")
	public void updateUser() {
	}

	@DeleteMapping("/v1/user")
	public void deleteUser() {
	}
}