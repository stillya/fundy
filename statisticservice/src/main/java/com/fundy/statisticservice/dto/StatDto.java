package com.fundy.statisticservice.dto;

import com.fundy.commons.types.CategoryType;
import com.fundy.commons.types.TransactionType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatDto {

  private UUID accountId;
  private CategoryType category;
  private Integer percent;
  private TransactionType type;
}
