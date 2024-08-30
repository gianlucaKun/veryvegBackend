package com.veryveg.product.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veryveg.product.DTO.UserDTO;
import com.veryveg.product.service.UserService;

@RestController
@RequestMapping("/jwt")
public class LoginController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDTO loginRequest) {
		System.out.println(loginRequest.getEmail() + " | " + loginRequest.getPassword());
		
		boolean authenticationResult = userService.loginService(loginRequest.getEmail(), loginRequest.getPassword());
		
		if (authenticationResult) {
			
			String token = jwtService.generateToken(loginRequest.getUsername());
			
			return ResponseEntity.ok(token);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticazione Fallita");
		}
	}

}
