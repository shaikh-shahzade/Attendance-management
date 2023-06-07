package com.org.attendance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.attendance.exceptions.ResourceNotFoundException;
import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;
import com.org.attendance.repository.AttendanceRepository;
import com.org.attendance.repository.UserRepository;
import com.org.attendance.service.UserService;
import com.org.attendance.util.AttendanceHelper;
import com.org.attendance.util.UserHelper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AttendanceRepository attendanceRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		User u = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User" , id));
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(userRepo.existsByEmail(user.getEmail()))
			throw new ResourceNotFoundException("Already exist","email" ,2);
		User savedUser = userRepo.save(user);
		
		return savedUser;
	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		User u = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User" , id));
		u = UserHelper.mapUser(u, user);
		
		return userRepo.save(u);
	}

	@Override
	public User deleteUser(Long id) {
		// TODO Auto-generated method stub
		User u= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance", "User" , id));
		userRepo.delete(u);
		return u;
	}
	
	@Override
	public Attendance markAttendance(Attendance attendance , Long id) {
		// TODO Auto-generated method stub
		
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance", "User" , id));
		attendance.setUser(user);
		attendance = attendanceRepo.save(attendance);
		
		return attendance;
	}

	@Override
	public Attendance updateAttendance(Attendance attendance, Long id) {
		// TODO Auto-generated method stub
		
		Attendance att= attendanceRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance", "User" , id));
		att= AttendanceHelper.updateObject(att, attendance);
		att = attendanceRepo.save(att);
		return att;
	}

	@Override
	public Attendance deleteAttendance(Long id) {
		// TODO Auto-generated method stub
		Attendance attendance = attendanceRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance", "User" , id));
		attendanceRepo.delete(attendance);
		return attendance;
	}

	@Override
	public List<Attendance> getAllAttendanceByUserId(Long id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance", "User" , id));
		List<Attendance> attendanceList = attendanceRepo.findAllByUser(user);
		return attendanceList;
	}


	

}
