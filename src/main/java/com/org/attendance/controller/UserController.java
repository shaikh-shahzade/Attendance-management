package com.org.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public User getUserById(@RequestParam Long id)
	{
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user ,@RequestParam Long id)
	{
		return userService.updateUser(user ,id);
	}
	
	@DeleteMapping
	public User deleteUser(@RequestParam Long id)
	{
		return userService.deleteUser(id);
	}

	@GetMapping("attendance")
	public List<Attendance> getAllAttendanceByUserId(@RequestParam(name = "id") Long id	)
	{
		return userService.getAllAttendanceByUserId(id);	
	}
	
	@PostMapping("attendance")
	public Attendance markAttendance(@RequestBody Attendance attendance ,
								     @RequestParam(name = "id") Long id	)
	{
		return userService.markAttendance(attendance,id);
	}
	
	@PutMapping("attendance")
	public Attendance updateAttendance(@RequestBody Attendance attendance ,
								     @RequestParam(name = "id") Long id	)
	{
		return userService.updateAttendance(attendance,id);
	}
	
	@DeleteMapping("attendance")
	public Attendance deleteAttendance(@RequestParam(name = "id") Long id	)
	{
		return userService.deleteAttendance(id);
	}
	
}
