package com.example.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exam.entity.User;
import com.example.exam.entity.UserRole;
import com.example.exam.helper.UserFoundException;
import com.example.exam.repository.RoleRepository;
import com.example.exam.repository.UserRepository;
import com.example.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User user1=this.userRepository.findByUsername(user.getUsername());
		
		if(user1!=null)
		{
			System.out.println("User is already there !!");
			throw new UserFoundException("User already present");
			
		}else {
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			user1=this.userRepository.save(user);
			
		}
		return user1;
	}

	//getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}
    
}
