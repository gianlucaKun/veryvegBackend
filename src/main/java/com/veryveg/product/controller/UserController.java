package com.veryveg.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	    public ResponseEntity<Object> createUser(@RequestBody User u) {
	        try {
	            UserDTO createdUser = uService.createUserService(u);
	            return ResponseEntity.ok(createdUser);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
}
