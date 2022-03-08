package com.poc5.doa;

import com.poc5.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, String> {

//	@Query("from Employee where DATE_FORMAT(dob, '%m-%d') > DATE_FORMAT(?1, '%m-%d') order by DATE_FORMAT(dob, '%m-%d')")
//	List<Employee> findByDobSorted(String date); 
}
