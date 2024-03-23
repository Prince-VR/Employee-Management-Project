package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.bean.Employee;
import com.gl.dao.EmployeeDAO;
import com.gl.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO edao;
	

	@Override
	public Employee addEmployee(Employee emp) {

		return edao.save(emp);
	}

	
	@Override
	public Employee getEmployeeById(int id) {

		if (edao.findById(id).isPresent()) {
			return edao.findById(id).get();
		} else {
			throw new ResourceNotFoundException("Employee with id : " + id + " is not Found");
		}

	}

	
	@Override
	public List<Employee> getAllEmployees() {

		return edao.findAll();
	}

	
	@Override
	public boolean deleteEmployeeById(int id) {

		if (edao.findById(id).isPresent()) {
			edao.deleteById(id);
			return true;
		} else {
			throw new ResourceNotFoundException("Employee with id : " + id + " is not Found");
		}
	}

	
	@Override
	public Employee updateEmployeeById(Employee emp, int id) {

		if (edao.findById(id).isPresent()) {

			Employee e1 = edao.findById(id).get();

			e1.setFirstName(emp.getFirstName());
			e1.setLastName(emp.getLastName());
			e1.setEmail(emp.getEmail());

			edao.save(e1);

			return e1;
		}

		return null;
	}

	
	@Override
	public List<Employee> findEmployeeByName(String query) {

		List<Employee> employee = edao.findEmployeeByName(query);

		return employee;
	}

	
	public List<Employee> sortEmployeeAsc(String field) {

		return edao.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	
	public List<Employee> sortEmployeeDesc(String field) {

		return edao.findAll(Sort.by(Sort.Direction.DESC, field));
	}

}
