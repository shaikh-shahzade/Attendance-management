package com.org.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;
import com.org.attendance.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	
	
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@PostMapping("attendance")
	public Attendance markAttendance(@RequestBody Attendance attendance ,
								     @RequestParam(name = "id") Long id	)
	{
		return userService.markAttendance(attendance,id);
	}
	
}
