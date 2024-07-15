package com.veryveg.product.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private String id;

    private String name;
    private String description;
    private boolean vegan;
    private boolean vegetarian;

}

