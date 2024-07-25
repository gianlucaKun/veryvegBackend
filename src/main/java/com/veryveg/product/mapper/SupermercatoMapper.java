package com.veryveg.product.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import com.veryveg.product.DTO.SupermercatoDTO;
import com.veryveg.product.DTO.UserDTO;
import com.veryveg.product.entity.Supermercato;
import com.veryveg.product.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Mapper
public interface SupermercatoMapper {


	Supermercato toSupermercatoEntity (SupermercatoDTO dto);
	
SupermercatoDTO toSupermercatoDTO (Supermercato s);
	
	List<Supermercato> ListToSupermercatoEntity (List<SupermercatoDTO> dtoList);
	
	List<SupermercatoDTO> ListToSupermercatoDTO (List<Supermercato> sList);
}
