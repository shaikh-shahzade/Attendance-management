package com.org.attendance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.org.attendance.exceptions.ResourceNotFoundException;
import com.org.attendance.model.User;
import com.org.attendance.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println("YEss" + username);
		User user = userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("email", username, 0));
		//System.out.println(user.getEmail());
		return new CustomUserDetails(user);
	}

}
