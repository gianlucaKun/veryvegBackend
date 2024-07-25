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
@Document(collection = "supermercato")
public class Supermercato {

	@Id
	private String id;
	
	private String name;
	
	@DBRef
	private Set<Product> prodotti;
}
