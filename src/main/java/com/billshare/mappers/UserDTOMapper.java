package com.billshare.mappers;

import org.mapstruct.Mapper;

import com.billshare.entities.UserEntity;
import com.billshare.models.dtos.UserDTO;

@Mapper
public interface UserDTOMapper {
	
	UserDTO convertEntityToDTO(UserEntity user);
	
	UserEntity convertDtoToEntity(UserDTO userDTO);
}
