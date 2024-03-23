package com.gl.service;

import java.util.List;

import com.gl.bean.User;

public interface UserService {

	public User addUser(User u);
	public List<User> getAllUsers();

}
