package com.veryveg.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    
    @Id
    private String id;

    private String name;
    private String description;
    private String barcode;
    private boolean vegan;
    private boolean vegetarian;
    private boolean confirmed;

    @DBRef
    private Set<Ingredient> ingredients;
}
