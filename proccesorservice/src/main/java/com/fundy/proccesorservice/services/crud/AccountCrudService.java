package com.fundy.proccesorservice.services.crud;

import com.fundy.commons.dto.AccountDto;
import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.entities.AccountEntity;
import com.fundy.proccesorservice.mappers.AccountMapper;
import com.fundy.proccesorservice.repository.AccountRepository;
import com.fundy.proccesorservice.utils.ConverterHelper;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountCrudService {

  private final AccountRepository accountRepository;

  public List<AccountDto> getAccounts() {
    return this.accountRepository.findAll().stream().map(AccountMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  public AccountDto getAccountById(UUID id) {
    return AccountMapper.INSTANCE.toDto(this.accountRepository.findById(id).get());
  }

  public AccountDto getAccountByUserId(UUID userId) {
    return AccountMapper.INSTANCE.toDto(this.accountRepository.getByUserId(userId));
  }

  @Transactional
  public AccountDto createAccount(AccountCreateDto dto) {
    return AccountMapper.INSTANCE
        .toDto(this.accountRepository.save(ConverterHelper.AccountCreateDtoAccountEntity(dto)));
  }

  @Transactional
  public AccountDto updateBalance(UUID accountId, BigInteger balance) {
    AccountEntity account = this.accountRepository.findById(accountId).orElseThrow(() ->
        new RuntimeException("Account not found id = " + accountId));

    account.setBalance(balance);

    return AccountMapper.INSTANCE.toDto(this.accountRepository.save(account));
  }
}
