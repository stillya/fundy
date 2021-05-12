package com.fundy.proccesorservice.mappers;

import com.fundy.commons.dto.AccountDto;
import com.fundy.proccesorservice.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

  AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "balance", source = "balance")
  @Mapping(target = "user", source = "user")
  AccountDto toDto(AccountEntity entity);

  AccountEntity toEntity(AccountDto dto);

}
