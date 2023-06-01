package com.org.attendance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.attendance.model.User;
import com.org.attendance.repository.UserRepository;
import com.org.attendance.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User assignManager(Long userId, Long managerId)  {
		// TODO Auto-generated method stub
		if(userId==null||managerId==null) {
			User u = userRepository.findById(userId).get();
		
		User manager = userRepository.findById(managerId).get();
		u.setManager(manager);

		return userRepository.save(u);
		}
		return null;
	}

}
