package com.poc2.controller;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import api.soap.demo.employees.AddEmployeeRequest;
import api.soap.demo.employees.AddEmployeeResponse;
import api.soap.demo.employees.DeleteEmployeeRequest;
import api.soap.demo.employees.DeleteEmployeeResponse;
import api.soap.demo.employees.Employee;
import api.soap.demo.employees.GetEmployeeRequest;
import api.soap.demo.employees.GetEmployeeResponse;
import api.soap.demo.employees.Status;
import api.soap.demo.employees.UpdateEmployeeRequest;
import api.soap.demo.employees.UpdateEmployeeResponse;

@Endpoint
public class StudentEndpoint {
	
	@Autowired
	private JdbcTemplate template;

	@PayloadRoot(namespace = "http://demo.soap.api/employees", localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		
		//Connecting to database
		List<Employee> employees= template.query("select * from employee where id="+request.getId(), new BeanPropertyRowMapper<Employee>(Employee.class));
		
//	    employee.setId(request.getId());
//	    employee.setName("Adam");
//	    employee.setSalary(100000);

	    response.setEmployee(employees.get(0));

	    return response;
	}
	
	@PayloadRoot(namespace = "http://demo.soap.api/employees", localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();

		Employee emp = request.getEmployee();

		int result = template.update(
				"insert into employee values(?, ?, ?, ?)",
				emp.getId(),
				emp.getName(),
				emp.getSalary(),
				emp.getAddress()
				);
		
		Status status = new Status();
		if(result == 1) {
			status.setTitle("Success");
			status.setMessage("Successfully inserted the details");
		}
		else {
			status.setTitle("Faild");
			status.setMessage("Something went wrong while inserting the details");
		}
		response.setStatus(status);
		response.setEmployee(emp);
		
	    return response;
	}
	
	@PayloadRoot(namespace = "http://demo.soap.api/employees", localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();

		Employee emp = request.getEmployee();

		int result = template.update(
				"update employee SET name=?, salary=?, address=? where id=?",
				emp.getName(),
				emp.getSalary(),
				emp.getAddress(),
				emp.getId()
				);
		
		Status status = new Status();
		if(result == 1) {
			status.setTitle("Success");
			status.setMessage("Successfully updated the details of employee with id: "+ emp.getId());
		}
		else {
			status.setTitle("Faild");
			status.setMessage("Something went wrong while updating the details");
		}
		response.setStatus(status);
		
		
	    return response;
	}
	
	@PayloadRoot(namespace = "http://demo.soap.api/employees", localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();

		
		int result = template.update("delete from employee where id=?",request.getId());

		Status status = new Status();
		if(result == 1) {
			status.setTitle("Success");
			status.setMessage("Successfully deleted the details of employee with id: "+request.getId());
		}
		else {
			status.setTitle("Faild");
			status.setMessage("Something went wrong while deleting the details of employee");
		}
		response.setStatus(status);
		
	    return response;
	}
}
