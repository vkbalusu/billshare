package com.billshare.mappers;

import org.mapstruct.Mapper;

import com.billshare.entities.FriendEntity;
import com.billshare.models.dtos.FriendDTO;

@Mapper
public interface FriendDTOMapper {
	
	FriendDTO convertEntityToDTO(FriendEntity user);
}
