package com.billshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.billshare.entities.GroupEntity;
import com.billshare.entities.UserEntity;
import com.billshare.models.dtos.GroupDTO;

@Mapper
public interface GroupDTOMapper {
	
	@Mapping(source = "createdBy", target = "createdBy", qualifiedByName = "getUserName")
	public GroupDTO convertEntityToDTO(GroupEntity entity);
	
	@Named("getUserName")
	public static String getUserName(UserEntity userEntity) {
		return userEntity.getFirstName() + " " + userEntity.getLastName();
	}
}
