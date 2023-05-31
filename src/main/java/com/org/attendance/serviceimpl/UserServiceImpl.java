package com.org.attendance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.attendance.model.User;
import com.org.attendance.repository.UserRepository;
import com.org.attendance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		
		User savedUser = userRepo.save(user);
		
		return savedUser;
	}

}
