package com.fundy.proccesorservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateDto {

  private String name;
}
