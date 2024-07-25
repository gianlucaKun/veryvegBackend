package com.veryveg.product.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.veryveg.product.DTO.ListaSpesaDTO;
import com.veryveg.product.entity.ListaSpesa;


@Mapper
public interface ListaSpesaMapper {

	ListaSpesa toListEntity(ListaSpesaDTO dto);

	ListaSpesaDTO toListrDTO(ListaSpesa u);

	List<ListaSpesa> ListToListEntity(List<ListaSpesaDTO> dtoList);

	List<ListaSpesaDTO> ListToListDTO(List<ListaSpesa> eList);
}
