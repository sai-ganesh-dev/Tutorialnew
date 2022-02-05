package com.example.tutorial.exception;

import javax.xml.bind.ValidationException;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.tutorial.common.Apiresponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Apiresponse> conflict(DataIntegrityViolationException ex){
		
		        String message = ex.getMessage();
		
		
		return new ResponseEntity<Apiresponse>(new Apiresponse(false, message),HttpStatus.CONFLICT);
		
	}
	
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Apiresponse> validationException(ValidationException ex){
		String message = ex.getMessage();
		
		return new ResponseEntity<Apiresponse>(new Apiresponse(false, message), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Apiresponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
		ex.printStackTrace();
		
		String message = ex.getMessage();
		return new ResponseEntity<Apiresponse>(new Apiresponse(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Apiresponse> unhandledExceptions(Exception ex){
		String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();
		
		
		ex.printStackTrace();
		
		return new ResponseEntity<Apiresponse>(new Apiresponse(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	private String getMostSpecificMessage(DataIntegrityViolationException ex) {
		
		String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();
		
		if(message.contains("Detail:")) {
			message = message.substring(message.indexOf("Detail:")+"Detail:".length());
		}
		
		return message;
	}
	
	
}
