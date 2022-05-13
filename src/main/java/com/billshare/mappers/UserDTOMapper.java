package com.billshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.billshare.entities.UserEntity;
import com.billshare.models.dtos.UserDTO;

@Mapper
public interface UserDTOMapper {
	
    void convertEntityToDTO(UserEntity user, @MappingTarget UserDTO userDTO);
	
    void convertDtoToEntity(UserDTO userDTO, @MappingTarget UserEntity user);
}
