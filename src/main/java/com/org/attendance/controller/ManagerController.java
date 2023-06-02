package com.org.attendance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.attendance.model.Attendance;
import com.org.attendance.model.User;
import com.org.attendance.service.ManagerService;

@RestController
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@GetMapping
	public List<User> getUsers()
	{
		return managerService.getAllUsers();
	}
	
	@PutMapping("assign")
	public User assignManager(@RequestBody  Map<String , Long> map )
	{
		return managerService.assignManager(map.get("userId"),map.get("managerId"));
	}
	
	@GetMapping("attendance/{id}")
	public List<Attendance> getAttendanceByUserId(@PathVariable(name = "id") Long  id)
	{
		return managerService.getAttendanceByUserId(id);
	}

}
