package com.ass.employee.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ass.employee.exception.employeeIdNotFoundException;

@RestControllerAdvice
public class ExceptionHandler 
{
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(employeeIdNotFoundException .class)
	public Map<String, String> employeeIdNotFound(employeeIdNotFoundException exp)
	{
		Map<String,String> map = new HashMap<>();
		
		map.put("error message", exp.getMessage());
		
		return map;
	}
	
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> InvalidExceptionHendler(MethodArgumentNotValidException exp)
	{
		Map<String,String> map = new HashMap<>();
		exp.getBindingResult().getFieldErrors().forEach(error ->{
			
			map.put(error.getField(), error.getDefaultMessage());
			
			
		});
		
		return map;
		
	}

}
