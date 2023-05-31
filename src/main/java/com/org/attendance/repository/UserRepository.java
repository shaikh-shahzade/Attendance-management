package com.org.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.attendance.model.User;

public interface UserRepository extends JpaRepository<User	, Long> {

}
