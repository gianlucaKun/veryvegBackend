package com.veryveg.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veryveg.product.DTO.IngredientDTO;
import com.veryveg.product.entity.Ingredient;
import com.veryveg.product.mapper.IngredientMapper;
import com.veryveg.product.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private IngredientMapper ingredientMapper;

	public List<IngredientDTO> getAllService() {
		List<Ingredient> allIngredient = ingredientRepository.findAll();

		return ingredientMapper.toIngredientDTOs(allIngredient);
	}

	public IngredientDTO getOneService(String name) {
		Optional<Ingredient> finded = ingredientRepository.findByName(name);

		if (finded != null) {

			return ingredientMapper.toIngredientDTO(finded.get());
		}
		return null;
	}
}
