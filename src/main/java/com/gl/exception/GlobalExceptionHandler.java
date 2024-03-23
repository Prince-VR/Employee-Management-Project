package com.gl.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> customResourceNotFoundException(ResourceNotFoundException res,WebRequest wr){
		
		ErrorDetails err = ErrorDetails.builder().
				date(LocalDateTime.now()).
				message(res.getMessage()).
				status("Employee Not Found").
				path(wr.getDescription(false)).build();
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

}
