package com.org.attendance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.attendance.model.User;

public interface UserRepository extends JpaRepository<User	, Long> {

	public Optional<User> findByEmail(String email);
	
	public Boolean existsByEmail(String email);
}
