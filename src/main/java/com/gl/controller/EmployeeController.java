package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.bean.Employee;
import com.gl.service.EmployeeService;
import com.gl.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService eservice;
	
	@Autowired
	EmployeeServiceImpl eserimpl;
	
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		
		return new ResponseEntity<>(eservice.addEmployee(emp), HttpStatus.OK);
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		return new ResponseEntity<>(eservice.getAllEmployees(),HttpStatus.OK);
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		
		return new ResponseEntity<>(eservice.getEmployeeById(id), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("id") int id){
		
		return new ResponseEntity<>(eservice.deleteEmployeeById(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee emp, @PathVariable("id") int id){
		
		return new ResponseEntity<>(eservice.updateEmployeeById(emp, id), HttpStatus.OK);
	}

	
	@GetMapping("/employees/search")
	public ResponseEntity<List<Employee>> findEmployeeByName(@RequestParam("query") String query){
		
		return ResponseEntity.ok(eservice.findEmployeeByName(query));
	}
	
	
	@GetMapping("/employees/sort/{field}/Asc")
	public List<Employee> sortEmployeeAsc(@PathVariable String field){
		
		return eserimpl.sortEmployeeAsc(field);
	}
	
	
	@GetMapping("/employees/sort/{field}/Desc")
	public List<Employee> sortEmployeeDesc(@PathVariable String field){
		
		return eserimpl.sortEmployeeDesc(field);
	}
	
}

