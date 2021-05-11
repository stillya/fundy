package com.fundy.proccesorservice.mappers;

import com.fundy.commons.dto.AccountDto;
import com.fundy.proccesorservice.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

  AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

  AccountDto toDto(AccountEntity entity);

  AccountEntity toEntity(AccountDto dto);

}
