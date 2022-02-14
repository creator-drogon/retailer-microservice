package com.order.exceptionhandling;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataNotFoundException extends RuntimeException{

	public DataNotFoundException(String message){
		super(message + " ##### ");
	}
	
	public DataNotFoundException(long id) {
		super("#### Product with id "+id + " Not found #####");
		
	}
}
