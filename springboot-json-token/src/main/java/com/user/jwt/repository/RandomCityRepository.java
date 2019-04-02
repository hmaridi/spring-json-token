package com.user.jwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.jwt.domain.RandomCity;

@Repository
public interface RandomCityRepository extends CrudRepository<RandomCity, Long> {
}
