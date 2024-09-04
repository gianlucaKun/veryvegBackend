package com.veryveg.product.DTO;

import org.springframework.data.annotation.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	
	private String id;
	
	private String username;
	private String password;
	private String email;
	private String name;
	private String lastname;
	private String role;

}