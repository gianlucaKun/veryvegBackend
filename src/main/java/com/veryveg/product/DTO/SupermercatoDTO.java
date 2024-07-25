package com.veryveg.product.DTO;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupermercatoDTO {


	private String id;
	
	private String name;
	
	private Set<ProductDTO> prodotti;
}
