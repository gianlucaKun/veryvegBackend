package com.veryveg.product.mapper;

import java.util.List;


import org.mapstruct.Mapper;

import com.veryveg.product.DTO.TipiProdottoDTO;
import com.veryveg.product.entity.TipiProdotto;



@Mapper
public interface TipiProdottoMapper {

	
	TipiProdotto toTipiProdottoEntity (TipiProdottoDTO dto);
	
TipiProdottoDTO toTipiProdottoDTO (TipiProdotto tp);
	
	List<TipiProdotto> ListToTipiProdottoEntity (List<TipiProdottoDTO> dtoList);
	
	List<TipiProdottoDTO> ListToTipiProdottoDTO (List<TipiProdotto> tpList);
}
