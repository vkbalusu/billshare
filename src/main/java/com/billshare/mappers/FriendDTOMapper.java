package com.billshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.billshare.entities.FriendEntity;
import com.billshare.models.dtos.FriendDTO;

@Mapper
public interface FriendDTOMapper {
	
	void convertEntityToDTO(FriendEntity user, @MappingTarget FriendDTO userDTO);
}
