package com.codingdojo.loginReg.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.loginReg.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	    
	    Optional<User> findByEmail(String email);
	}