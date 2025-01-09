package com.tka.exceptions;

public class MatchNotFoundException extends Exception {

	public String message ;
	public MatchNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}
