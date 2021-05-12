package com.fundy.proccesorservice.controllers;

import com.fundy.commons.dto.AccountDto;
import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.dto.TransactionCreateDto;
import com.fundy.proccesorservice.services.core.ProcessingService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProcessingController {

  private final ProcessingService processingService;

  @GetMapping(path = "/{userId}")
  public AccountDto getAccount(@PathVariable("userId") UUID userId) {
    return this.processingService.getAccount(userId);
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

}
