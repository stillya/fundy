package com.fundy.commons.dto;

import java.math.BigInteger;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

  private UUID id;
  private String name;
  private String description;
  private BigInteger balance;
  private UserDto user;

}
