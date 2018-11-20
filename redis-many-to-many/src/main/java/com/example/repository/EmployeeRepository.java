package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{

	List<Employee> findByAddresses_Street(String street);
	
	List<Employee> findByAddresses_City(String city);
	
	List<Employee> findByDepartments_Projects_ProjectCategory(String category);
	
	
	List<Employee> findByDepartments_DepartmentName(String departmentNames);
}
