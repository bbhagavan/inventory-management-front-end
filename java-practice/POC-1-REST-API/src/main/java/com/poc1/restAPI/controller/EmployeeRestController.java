package com.poc1.restAPI.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.poc1.restAPI.doa.EmployeeRepo;
import com.poc1.restAPI.model.Employee;


@RestController
public class EmployeeRestController {
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("employees")
	public List<Employee> getEmployees() {
		
		return (List<Employee>) repo.findAll();
	}
	
	@RequestMapping("/adddefault")
	public String addDefault() {
		
		repo.save(new Employee("001", "Alice", "Female", new Date(99, 2, 15)));
		repo.save(new Employee("002", "Bob", "Male", new Date(99, 10, 19)));
		repo.save(new Employee("003", "Cristie", "Female", new Date(100, 06, 25)));
		
		return "Three employees added into database..";
	}
	
	@RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
	public Optional<Employee> getEmployees(@PathVariable String id) {
		
		return repo.findById(id);
	}
	
	@RequestMapping(value = "employee", method = RequestMethod.PUT)
	public String updateEmployees(Employee emp) {
		
		repo.save(emp);
		
		return "Updated employee: "+emp;
	}
	
	@RequestMapping(value = "employee", method = RequestMethod.POST)
	public String addEmployee(Employee emp) {
		repo.save(emp);
		
		return "Successfully added: "+emp;
	}
	
	@RequestMapping(value="employee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable String id) {
		
		repo.deleteById(id);
		
		return "Deletion is successfull..";
	}

}
