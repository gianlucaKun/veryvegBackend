package com.veryveg.product.repository;

import com.veryveg.product.entity.Ingredient;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {

	Optional<Ingredient> findByName(String name);
	
}