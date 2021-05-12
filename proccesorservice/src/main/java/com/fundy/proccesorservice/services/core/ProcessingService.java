package com.fundy.proccesorservice.services.core;

import com.fundy.commons.dto.AccountDto;
import com.fundy.commons.types.TransactionType;
import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.dto.TransactionCreateDto;
import com.fundy.proccesorservice.services.crud.AccountCrudService;
import com.fundy.proccesorservice.services.crud.TransactionCrudService;
import com.fundy.proccesorservice.services.crud.UsersCrudService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProcessingService {

  private final AccountCrudService accountCrudService;
  private final TransactionCrudService transactionCrudService;
  private final UsersCrudService usersCrudService;

  public AccountDto getAccount(UUID userId) {
    return this.accountCrudService.getAccountByUserId(userId);
  }

  @Transactional
  public AccountDto createAccount(AccountCreateDto account) {
    return this.accountCrudService.createAccount(account);
  }

  @Transactional
  public AccountDto addIncome(TransactionCreateDto transactionCreateDto) {

    if (!transactionCreateDto.getType().equals(TransactionType.INCOME)) {
      throw new RuntimeException(
          "Type of transaction isn't income on accountId=" + transactionCreateDto.getAccountId());
    }
    AccountDto account = this.accountCrudService
        .getAccountById(transactionCreateDto.getAccountId());

    transactionCreateDto.setCurrentBalance(account.getBalance());

    this.transactionCrudService.createTransaction(transactionCreateDto);

    return this.accountCrudService.updateBalance(transactionCreateDto.getAccountId(),
        transactionCreateDto.getCurrentBalance().add(transactionCreateDto.getAmount()));
  }

  @Transactional
  public AccountDto addExpenses(TransactionCreateDto transactionCreateDto) {

    if (!transactionCreateDto.getType().equals(TransactionType.EXPENSE)) {
      throw new RuntimeException(
          "Type of transaction isn't expenses on accountId=" + transactionCreateDto.getAccountId());
    }
    AccountDto account = this.accountCrudService
        .getAccountById(transactionCreateDto.getAccountId());

    transactionCreateDto.setCurrentBalance(account.getBalance());

    this.transactionCrudService.createTransaction(transactionCreateDto);

    return this.accountCrudService.updateBalance(transactionCreateDto.getAccountId(),
        transactionCreateDto.getCurrentBalance().subtract(transactionCreateDto.getAmount()));
  }

}
