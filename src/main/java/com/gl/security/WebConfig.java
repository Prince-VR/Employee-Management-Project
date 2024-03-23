package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService uds;

	public AuthenticationProvider getAuthenticationProvider() {
		
		DaoAuthenticationProvider daop = new DaoAuthenticationProvider();
		daop.setUserDetailsService(uds);
		daop.setPasswordEncoder(getPasswordEncoder());

		return daop;
	}

	
	@Bean public PasswordEncoder getPasswordEncoder() {
	  
	  return new BCryptPasswordEncoder();
	  
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/employees", "/api/employees/{id}")
		.hasAnyAuthority("admin", "user")
		.antMatchers(HttpMethod.POST, "/api/employees")
		.hasAnyAuthority("admin")
		.antMatchers(HttpMethod.DELETE, "/api/employees/{id}")
		.hasAnyAuthority("admin")
		.antMatchers(HttpMethod.PUT, "/api/employees/{id}")
		.hasAnyAuthority("admin")
		.anyRequest().authenticated().and().httpBasic().and().cors().and().csrf().disable();

	}
}
