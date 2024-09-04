package com.veryveg.product.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

	@Id
	private String id;
	
	private String username;
	private String password;
	private String email;
	private String name;
	private String lastname;
	private String role;
	
}
