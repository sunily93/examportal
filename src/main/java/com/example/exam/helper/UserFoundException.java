package com.example.exam.helper;

public class UserFoundException extends Exception{
	public UserFoundException() {
		super("User with this username is already there in Database..");
	}
	
	public UserFoundException(String msg) {
		super(msg);
	}
}
