package com.org.attendance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.attendance.model.User;

@RestController
@RequestMapping("manager")
public class ManagerController {
	
	public User assignManager()
	{
		return null;
	}

}
