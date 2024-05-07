package com.bebegiboo.project.certification.model.exception;

public class InsertException extends RuntimeException {

	
	public InsertException() {
		super("삽입 중 예외발생"); 
	}
	
	public InsertException(String message) {
		super(message); 
	}
}
