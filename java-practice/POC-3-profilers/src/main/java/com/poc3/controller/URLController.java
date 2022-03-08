package com.poc3.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc3.model.Employee;

@RestController
public class URLController {
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private Repository repo;
	
	@RequestMapping("/jdbc")
	public List<Employee> getEmployeesJDBC(){
//		template.update("delete from employee where Id='901'");
		return template.query("select * from employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	@RequestMapping("/h2")
	public List<Employee> getEmployeesH2() throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		repo.save(new Employee("901", "Test", "Male",dateFormat.parse("2020-04-08")));
		repo.save(new Employee("902", "Test1", "Female",dateFormat.parse("2020-05-28")));
		
		return (List<Employee>) repo.findAll();
	}
}

@Component
interface Repository extends CrudRepository<Employee, String>{
	
}
