package com.user.jwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.jwt.domain.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
