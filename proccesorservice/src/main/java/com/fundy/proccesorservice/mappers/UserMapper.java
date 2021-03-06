package com.fundy.proccesorservice.mappers;

import com.fundy.commons.dto.UserDto;
import com.fundy.proccesorservice.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  UserDto toDto(UserEntity entity);

  UserEntity toEntity(UserDto dto);

}
