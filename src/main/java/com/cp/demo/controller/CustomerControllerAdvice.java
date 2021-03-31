package com.cp.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.demo.exception.CustomerNotFoundException;
import com.cp.demo.exception.ModelAddException;
import com.cp.demo.exception.ModelNotFoundException;



@RestControllerAdvice
public class CustomerControllerAdvice {
	@ExceptionHandler(ModelNotFoundException.class)
	public String productException(Exception e) {
		return e.getMessage();
		
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public String product1Exception(Exception e1) {
		return e1.getMessage();
		
	}
	@ExceptionHandler(ModelAddException.class)
	public String product2Exception(Exception e2) {
		return e2.getMessage();
		
	}




}
