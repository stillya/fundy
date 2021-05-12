package com.fundy.proccesorservice.mappers;

import com.fundy.commons.dto.TransactionDto;
import com.fundy.proccesorservice.entities.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "type", source = "type")
  @Mapping(target = "category", source = "category")
  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "currentBalance", source = "currentBalance")
  @Mapping(target = "creationDate", source = "creationDate")
  @Mapping(target = "account", source = "account")
  TransactionDto toDto(TransactionEntity entity);

  TransactionEntity toEntity(TransactionDto dto);

}
