package com.billshare.exceptions;

public class RecordAlreadyExistsException extends RuntimeException{
	
	public RecordAlreadyExistsException() {
		
	}
	
	public RecordAlreadyExistsException(String messgae) {
		super(messgae);
	}
}
