package com.example.exam.helper;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User with this username is not in Database..");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
