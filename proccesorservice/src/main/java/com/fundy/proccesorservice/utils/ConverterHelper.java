package com.fundy.proccesorservice.utils;

import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.dto.TransactionCreateDto;
import com.fundy.proccesorservice.dto.UserCreateDto;
import com.fundy.proccesorservice.entities.AccountEntity;
import com.fundy.proccesorservice.entities.TransactionEntity;
import com.fundy.proccesorservice.entities.UserEntity;

public class ConverterHelper {

  public static UserEntity UserCreateDtoUserEntity(UserCreateDto dto) {
    return UserEntity.builder()
        .name(dto.getName())
        .build();
  }

  public static AccountEntity AccountCreateDtoAccountEntity(AccountCreateDto dto) {
    return AccountEntity.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .userId(dto.getUserId())
        .build();
  }

  public static TransactionEntity TransactionCreateDtoTransactionEntity(TransactionCreateDto dto) {
    return TransactionEntity.builder()
        .accountId(dto.getAccountId())
        .name(dto.getName())
        .description(dto.getDescription())
        .type(dto.getType())
        .category(dto.getCategory())
        .amount(dto.getAmount())
        .currentBalance(dto.getCurrentBalance())
        .build();
  }

}
