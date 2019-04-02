package com.user.jwt.service;

import java.util.List;

import com.user.jwt.domain.RandomCity;
import com.user.jwt.domain.User;

public interface GenericService {
	public User findByUsername(String username);

	public List<User> findAllUsers();

	public List<RandomCity> findAllRandomCities();
	
	public User addUser(User user);
}
