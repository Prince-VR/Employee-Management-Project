package com.gl.service;

import java.util.List;

import com.gl.bean.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployeeById(int id);
	public Employee updateEmployeeById(Employee emp,int id); 
	
	List<Employee> findEmployeeByName(String query);

}
