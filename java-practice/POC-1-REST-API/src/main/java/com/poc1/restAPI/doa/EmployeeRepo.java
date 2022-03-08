package com.poc1.restAPI.doa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.poc1.restAPI.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, String> {

//	@Query("from Employee where DATE_FORMAT(dob, '%m-%d') > DATE_FORMAT(?1, '%m-%d') order by DATE_FORMAT(dob, '%m-%d')")
//	List<Employee> findByDobSorted(String date); 
}
