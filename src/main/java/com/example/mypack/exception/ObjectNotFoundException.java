package com.example.mypack.exception;

public class ObjectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897761895870370707L;

	
	public ObjectNotFoundException(String message) {
		super(message);
	}
	
}
