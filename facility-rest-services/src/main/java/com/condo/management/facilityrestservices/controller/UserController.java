package com.condo.management.facilityrestservices.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.condo.management.facilityrestservices.entity.User;
import com.condo.management.facilityrestservices.request.UserDto;
import com.condo.management.facilityrestservices.security.JwtAuthUtil;
import com.condo.management.facilityrestservices.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtAuthUtil authUtil;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/v1/user/{id}")
	public UserDto getUser(@PathVariable int id) throws Exception {
		User facilityUser = userService.getUser(id);
		UserDto facilityUserDto = modelMapper.map(facilityUser, UserDto.class);
		return facilityUserDto;
	}

	@PostMapping("/v1/authenticate/signup")
	public void createUser(@RequestBody UserDto user) {
		System.out.println("In");
		userService.createOrUpdateUser(modelMapper.map(user, User.class));
	}

	@PutMapping("/v1/user")
	public void updateUser(@RequestBody UserDto user) {
		userService.createOrUpdateUser(modelMapper.map(user, User.class));
	}

	@DeleteMapping("/v1/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

	@PostMapping("/v1/authenticate/signin")
	public String generateToken(@RequestBody UserDto user) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		User userFromDB = userService.findByEmail(user.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
		return authUtil.generateAccessToken(userFromDB);
	}
}