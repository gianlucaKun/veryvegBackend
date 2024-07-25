package com.veryveg.product.DTO;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferitiDTO {


	private String id;

	private Set<ProductDTO> prodotti;

	private Set<UserDTO> utente;
}
