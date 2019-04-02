package com.user.jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.jwt.domain.RandomCity;
import com.user.jwt.domain.User;
import com.user.jwt.repository.RandomCityRepository;
import com.user.jwt.repository.UserRepository;
import com.user.jwt.service.GenericService;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RandomCityRepository randomCityRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<RandomCity> findAllRandomCities() {
		return (List<RandomCity>) randomCityRepository.findAll();
	}

	public User addUser(User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		return userRepository.save(user);

	}

}
