package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.bean.User;
import com.gl.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User u){
		
		return new ResponseEntity<>(uservice.addUser(u), HttpStatus.OK);
	}

	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return new ResponseEntity<>(uservice.getAllUsers(),HttpStatus.OK);
	}
}
