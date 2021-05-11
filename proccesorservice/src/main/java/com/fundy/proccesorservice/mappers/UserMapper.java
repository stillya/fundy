package com.fundy.proccesorservice.mappers;

import com.fundy.commons.dto.UserDto;
import com.fundy.proccesorservice.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDto toDto(UserEntity entity);

  UserEntity toEntity(UserDto dto);

}
