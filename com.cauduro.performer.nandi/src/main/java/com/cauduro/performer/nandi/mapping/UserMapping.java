package com.cauduro.performer.nandi.mapping;

import org.mapstruct.Mapper;

import com.cauduro.performer.nandi.entity.UserEntity;
import com.cauduro.performer.nandi.models.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapping {

	UserModel toModel(UserEntity user);

	UserEntity toEntity(UserModel user);

}
