package com.fundy.notificationservice.dto;

import com.fundy.commons.types.NotificationPeriodType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {

  private UUID accountId;
  private NotificationPeriodType type;
  private String email;
  private int period;

}
