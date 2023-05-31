package com.org.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.attendance.model.User;


public interface UserService {

	public List<User> getAllUsers();

	public User createUser(User user);

}
