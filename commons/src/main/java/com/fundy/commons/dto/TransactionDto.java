package com.fundy.commons.dto;

import com.fundy.commons.types.CategoryType;
import com.fundy.commons.types.TransactionType;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

  private UUID id;
  private String name;
  private String description;
  private TransactionType type;
  private CategoryType category;
  private BigInteger amount;
  private BigInteger currentBalance;
  private LocalDateTime creationDate;
  private AccountDto account;

}

