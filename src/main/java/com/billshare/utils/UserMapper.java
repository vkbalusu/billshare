package com.billshare.utils;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.billshare.entities.User;
import com.billshare.models.forms.UpdateUserForm; 


@Mapper
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapUserDetails(UpdateUserForm dto, @MappingTarget User entity);
}
