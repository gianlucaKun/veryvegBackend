package com.veryveg.product.DTO;

import java.util.Set;
import com.veryveg.product.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String id;

    private String name;
    private String description;
    private String barcode;
    private boolean vegan;
    private boolean vegetarian;

    private Set<Ingredient> ingredients;
}


