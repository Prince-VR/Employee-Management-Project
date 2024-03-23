package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.bean.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	@Query(value = "SELECT * FROM employee WHERE "
			+ "first_Name LIKE CONCAT('%', :query,'%')", nativeQuery=true)
	List<Employee> findEmployeeByName(String query);
	
}