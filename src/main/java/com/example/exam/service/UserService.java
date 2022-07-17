package com.example.exam.service;

import java.util.Set;

import com.example.exam.entity.User;
import com.example.exam.entity.UserRole;

public interface UserService {

	//create user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get user 
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId); 
	
}
