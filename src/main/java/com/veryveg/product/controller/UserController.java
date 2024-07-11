package com.veryveg.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veryveg.product.DTO.UserDTO;
import com.veryveg.product.entity.User;
import com.veryveg.product.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/create")
	public UserDTO createUser (@RequestBody User u) {
		return uService.createUserService(u);
	}
}
