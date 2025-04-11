package com.hr_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_portal.entity.User;
import com.hr_portal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	public User login (String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		
		return user;
		
	}
}
