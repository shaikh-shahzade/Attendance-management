package com.org.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;


public interface UserService {

	public List<User> getAllUsers();

	public User createUser(User user);

	public Attendance markAttendance(Attendance attendance, Long id);

	public Attendance updateAttendance(Attendance attendance, Long id);

	public Attendance deleteAttendance(Long id);

	public List<Attendance> getAllAttendanceByUserId(Long id);

	public User updateUser(User user, Long id);

	public User deleteUser(Long id);

	public User getUserById(Long id);

}
