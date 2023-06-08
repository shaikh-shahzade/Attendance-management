package com.org.attendance.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;

public interface ManagerService {

	public List<User> getAllUsers();

	public User assignManager(Long userId, Long managerId);

	public List<Attendance> getAttendanceByUserId(Long id);

	public List<Attendance> searchAttendance(LocalDate date, String username, int page,int pagesize, String sortby);

	
}
