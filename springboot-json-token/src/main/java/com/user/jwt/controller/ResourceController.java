package com.user.jwt.controller;


import com.user.jwt.domain.ChangePassword;
import com.user.jwt.domain.RandomCity;
import com.user.jwt.domain.User;
import com.user.jwt.service.GenericService;
import com.user.jwt.service.impl.AppUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spring")
public class ResourceController {
	@Autowired
	private GenericService userService;

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@RequestMapping(value = "/cities")
	@PreAuthorize("hasAuthority('USER')")
	public List<RandomCity> getUser() {
		return userService.findAllRandomCities();
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<?> changePassword(@RequestBody ChangePassword changePassword) {
		appUserDetailsService.changePassword(changePassword.getOldPassword(), changePassword.getNewPassword());
		Map<String, String> result = new HashMap<>();
		result.put("result", "Your password has been changed successfully.");
		return ResponseEntity.accepted().body(result);
	}
}
