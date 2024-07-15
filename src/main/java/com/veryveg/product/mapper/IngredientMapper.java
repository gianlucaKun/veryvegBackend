package com.veryveg.product.mapper;

import com.veryveg.product.DTO.IngredientDTO;
import com.veryveg.product.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientDTO toIngredientDTO(Ingredient ingredient);
    Ingredient toIngredient(IngredientDTO ingredientDTO);

    List<IngredientDTO> toIngredientDTOs(List<Ingredient> ingredients);
    List<Ingredient> toIngredients(List<IngredientDTO> ingredientDTOs);
}