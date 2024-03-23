package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.bean.User;

import com.gl.dao.UserDAO;
import com.gl.exception.ResourceNotFoundException;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserDAO udao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u1;
		
		if(udao.findById(username).isPresent()) {
			u1=udao.findById(username).get();
		}
		else {
			throw new ResourceNotFoundException("User with name : "+username+ " not present");
		}
		
		return new MyUserDetails(u1);
	}

}