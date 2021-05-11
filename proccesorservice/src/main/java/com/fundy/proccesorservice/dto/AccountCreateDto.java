package com.fundy.proccesorservice.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreateDto {

  private String name;
  private String description;
  private UUID userId;
}
