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
	
	public UserDTO createUserService (User u) {
		Optional<User> finded = userRepo.findById(u.getId());
		
		if (finded == null) {
			User saved = userRepo.save(u);
			return userMap.toUserDTO(saved);
		}
		return null;
	}
}
