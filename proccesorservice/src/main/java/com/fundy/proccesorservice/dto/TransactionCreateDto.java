package com.fundy.proccesorservice.dto;

import com.fundy.commons.types.CategoryType;
import com.fundy.commons.types.TransactionType;
import java.math.BigInteger;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionCreateDto {

  private UUID accountId;
  private String name;
  private String description;
  private TransactionType type;
  private CategoryType category;
  private BigInteger amount;
  private BigInteger currentBalance;
}
