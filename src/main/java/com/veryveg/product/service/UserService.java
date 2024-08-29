package com.veryveg.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veryveg.product.DTO.UserDTO;
import com.veryveg.product.entity.User;
import com.veryveg.product.mapper.UserMapper;
import com.veryveg.product.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserMapper userMap;
	
	   public UserDTO createUserService(User u) {
	        Optional<User> existingUser = userRepo.findByEmail(u.getEmail());
	        
	        if (existingUser.isPresent()) {
	            throw new IllegalArgumentException("User already exists with email: " + u.getEmail());
	        }
	        
	        User savedUser = userRepo.save(u);
	        return userMap.toUserDTO(savedUser);
	    }

	   public boolean loginService (String email, String password) {
		   
		   User user = userRepo.findByEmail(email).orElseThrow();
		   
		   if (user != null && user.getPassword().equals(password)) {
			   
			   return true;
		   } else {
			   return false;
		   }
		   
		   
	   }
}
