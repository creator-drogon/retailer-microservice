package com.order.exceptionhandling;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnableToCreateException extends RuntimeException{

	public UnableToCreateException(String message){
		super(message + " ##### ");
	}
}
