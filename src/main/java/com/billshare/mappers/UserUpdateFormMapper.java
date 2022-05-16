package com.billshare.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.billshare.entities.UserEntity;
import com.billshare.models.forms.UpdateUserForm; 


@Mapper
public interface UserUpdateFormMapper {
	
//    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
//    UserEntity mapUserDetails(UpdateUserForm dto);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapUserDetails(UpdateUserForm dto, @MappingTarget UserEntity userEntity);
}
