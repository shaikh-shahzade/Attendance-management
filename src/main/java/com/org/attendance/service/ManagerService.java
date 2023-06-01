package com.org.attendance.service;

import java.util.List;

import com.org.attendance.model.User;

public interface ManagerService {

	public List<User> getAllUsers();

	public User assignManager(Long userId, Long managerId);

}
