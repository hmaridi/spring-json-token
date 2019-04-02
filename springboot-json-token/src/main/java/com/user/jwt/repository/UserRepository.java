package com.user.jwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.jwt.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   public  User findByUsername(String username);
}
