package com.poc5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc5.doa.EmployeeRepo;
import com.poc5.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String registration() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "addemployee", method = RequestMethod.GET)
	public String register() {
		return "home.jsp";
	}
	
	@RequestMapping(value = "addemployee", method = RequestMethod.POST)
	public String addEmployee(Employee emp) {
		repo.save(emp);
		
//		System.out.println(repo.findByDobSorted("2020-02-3"));
		
		return "home.jsp";
	}
	
	
	@RequestMapping(value = "updateemployee", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(Employee emp) {
		
		repo.save(emp);
		return "Updated" + emp;
	}
}
