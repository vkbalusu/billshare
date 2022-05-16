package com.billshare.mappers;

import org.mapstruct.Mapper;

import com.billshare.entities.CurrencyEntity;
import com.billshare.models.dtos.CurrencyDTO;

@Mapper
public interface CurrencyDTOMapper {
	
	CurrencyDTO convertEntityToDTO(CurrencyEntity user);
}
