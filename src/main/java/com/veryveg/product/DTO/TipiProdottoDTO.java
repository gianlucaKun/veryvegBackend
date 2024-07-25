package com.veryveg.product.DTO;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipiProdottoDTO {

	
	private String id;
	
	private String title;
	

	private Set<ProductDTO> prodotti;
}
