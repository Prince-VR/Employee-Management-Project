package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bean.User;
import com.gl.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO udao;
	
	
	@Override
	public User addUser(User u) {
		
		return udao.save(u);
	}
	

	@Override
	public List<User> getAllUsers() {
		
		return udao.findAll();
	}

}
