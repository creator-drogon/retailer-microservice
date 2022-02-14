package com.order.exceptionhandling;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import com.order.exceptionhandling.DataNotFoundException;
import com.order.exceptionhandling.UnableToCreateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> handleRequestForDataNotFoundException(DataNotFoundException ex, WebRequest request){
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getMessage());
		body.put("timestamp", LocalDate.now());
		return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnableToCreateException.class)
	public ResponseEntity<Object> handleRequestForUnableToCreateException(UnableToCreateException ex, WebRequest request){
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getMessage());
		body.put("timestamp", LocalDate.now());
		return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
	}
	
}
