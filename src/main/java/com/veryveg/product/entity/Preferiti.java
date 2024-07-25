package com.veryveg.product.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "preferiti")
public class Preferiti {

	@Id
	private String id;
	
	@DBRef
	private Set<Product> prodotti;
	@DBRef
	private Set<User> utente;
}
