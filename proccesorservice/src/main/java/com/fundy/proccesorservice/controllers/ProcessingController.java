package com.fundy.proccesorservice.controllers;

import com.fundy.commons.dto.AccountDto;
import com.fundy.commons.dto.TransactionDto;
import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.dto.TransactionCreateDto;
import com.fundy.proccesorservice.services.core.ProcessingService;
import com.fundy.proccesorservice.services.crud.TransactionCrudService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProcessingController {

  private final ProcessingService processingService;
  private final TransactionCrudService transactionCrudService;

  @GetMapping(path = "/{userId}")
  public AccountDto getAccount(@PathVariable("userId") UUID userId) {
    return this.processingService.getAccount(userId);
  }

  @GetMapping(path = "/transactions")
  public List<TransactionDto> getTransactionsByPeriod(@RequestParam("accountId") String accountId,
      @RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE_TIME)
          LocalDateTime startDate,
      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime endDate) {
    return this.transactionCrudService
        .getTransactionsByPeriod(UUID.fromString(accountId), startDate, endDate);
  }

  @GetMapping(path = "/transactions/limited")
  public List<TransactionDto> getLimitedTransactionsWithOffset(
      @RequestParam("accountId") String accountId,
      @RequestParam("limit") int limit, @RequestParam("offset") int offset) {
    return this.transactionCrudService
        .getLimitedTransactionsWithOffset(UUID.fromString(accountId), limit, offset);
  }

  @PostMapping(path = "/income")
  public AccountDto addIncome(@RequestBody TransactionCreateDto transaction) {
    return this.processingService.addIncome(transaction);
  }

  @PostMapping(path = "/expenses")
  public AccountDto addExpenses(@RequestBody TransactionCreateDto transaction) {
    return this.processingService.addExpenses(transaction);
  }

  @PostMapping
  public AccountDto createAccount(@RequestBody AccountCreateDto account) {
    return this.processingService.createAccount(account);
  }

  @GetMapping(path = "/count")
  public long countTransactions(@RequestParam("accountId") UUID accountId) {
    return this.transactionCrudService.count(accountId);
  }
}
