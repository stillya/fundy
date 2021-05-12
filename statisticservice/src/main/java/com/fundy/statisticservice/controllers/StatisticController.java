package com.fundy.statisticservice.controllers;

import com.fundy.statisticservice.dto.StatDto;
import com.fundy.statisticservice.services.StatisticService;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/statistic", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StatisticController {

  private final StatisticService statisticService;

  @GetMapping
  public List<StatDto> getStatistic(@RequestParam("userId") String userId,
      @RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE_TIME)
          LocalDateTime startDate,
      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime endDate) {
    return this.statisticService
        .getStatisticByPeriod(UUID.fromString(userId), startDate, endDate);
  }

  @GetMapping(path = "/income")
  public BigInteger getIncome(@RequestParam("userId") String userId,
      @RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE_TIME)
          LocalDateTime startDate,
      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime endDate) {
    return this.statisticService
        .getIncome(UUID.fromString(userId), startDate, endDate);
  }

  @GetMapping(path = "/expenses")
  public BigInteger getExpenses(@RequestParam("userId") String userId,
      @RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE_TIME)
          LocalDateTime startDate,
      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime endDate) {
    return this.statisticService
        .getExpenses(UUID.fromString(userId), startDate, endDate);
  }

}
