package com.fundy.commons.dto;

import java.math.BigInteger;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

  private UUID id;
  private String name;
  private String description;
  private BigInteger balance;
  private UserDto user;

}
