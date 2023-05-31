package com.org.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
		
	@GetMapping("")
	public String getDetails(Model model)
	{
		model.addAttribute("x" ,25);
		return "home";
	}
	
}
