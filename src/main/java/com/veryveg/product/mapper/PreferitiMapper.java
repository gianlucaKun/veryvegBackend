package com.veryveg.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.veryveg.product.DTO.PreferitiDTO;
import com.veryveg.product.entity.Preferiti;


@Mapper
public interface PreferitiMapper {

	Preferiti toPreferitiEntity(PreferitiDTO dto);

	PreferitiDTO toPreferitiDTO(Preferiti p);

	List<Preferiti> ListToPreferitiEntity(List<PreferitiDTO> dtoList);

	List<PreferitiDTO> ListToPreferitiDTO(List<Preferiti> pList);
}
