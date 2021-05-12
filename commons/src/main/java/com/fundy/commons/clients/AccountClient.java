package com.fundy.commons.clients;

import com.fundy.commons.dto.AccountDto;
import com.fundy.commons.dto.TransactionDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "account", url = "${hosts.account-service}:${hosts.account-service-port}/${hosts.account-service-prefix}")
public interface AccountClient {

  @RequestMapping(method = RequestMethod.GET, value = "/process/{userId}")
  AccountDto getAccount(@PathVariable("userId") UUID userId);

  @RequestMapping(method = RequestMethod.GET, value = "/process/transactions")
  List<TransactionDto> getTransactionsByPeriod(@RequestParam("accountId") String accountId,
      @RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE_TIME)
          LocalDateTime startDate,
      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime endDate);
}
