package com.fundy.proccesorservice.mappers;

import com.fundy.commons.dto.TransactionDto;
import com.fundy.proccesorservice.entities.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  TransactionDto toDto(TransactionEntity entity);

  TransactionEntity toEntity(TransactionDto dto);

}
