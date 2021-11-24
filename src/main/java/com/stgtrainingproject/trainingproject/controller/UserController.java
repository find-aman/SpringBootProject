package com.stgtrainingproject.trainingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stgtrainingproject.trainingproject.dao.UserRepository;
import com.stgtrainingproject.trainingproject.entities.User;

@RestController
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public String signup(@RequestBody User user) {
		
		try {
			User u = new User();
			u.setUserId(user.getUserId());
			u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			u.setRole(user.getRole());
			userRepository.save(u);
			
			return "User Added";
		} catch (Exception e) {
			e.printStackTrace();
			return "User Not Added";
			
		}
		
	}

}
