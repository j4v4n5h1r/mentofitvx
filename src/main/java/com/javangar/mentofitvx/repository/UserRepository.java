package com.javangar.mentofitvx.repository;

import com.javangar.mentofitvx.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	 
    Boolean existsByEmail(String email);
}
