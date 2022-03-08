package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.doa.EmployeeRepo;
import com.example.demo.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("employees")
	@ResponseBody
	public List<Employee> getEmployees() {
		
		return (List<Employee>) repo.findAll();
	}
	
	@RequestMapping("employee/{id}")
	@ResponseBody
	public Optional<Employee> getEmployees(@PathVariable String id) {
		
		return repo.findById(id);
	}
	
	@RequestMapping("getEmployees")
	public ModelAndView getEmployee(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("printEmployee.jsp");
		Employee employ = repo.findById(id).orElse(new Employee());
		mv.addObject(employ);
		
		return mv;
	}
	
	@RequestMapping("addEmployee")
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "home.jsp";
	}

}
