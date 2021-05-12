package com.fundy.statisticservice.services;

import com.fundy.commons.clients.AccountClient;
import com.fundy.commons.dto.AccountDto;
import com.fundy.commons.dto.TransactionDto;
import com.fundy.commons.types.CategoryType;
import com.fundy.commons.types.TransactionType;
import com.fundy.statisticservice.dto.StatDto;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StatisticService {

  private final AccountClient client;

  @Transactional
  public List<StatDto> getStatisticByPeriod(UUID userId, LocalDateTime startDate,
      LocalDateTime endDate) {
    AccountDto account = this.client.getAccount(userId);
    List<TransactionDto> transactions = this.client
        .getTransactionsByPeriod(account.getId().toString(), startDate, endDate).stream()
        .filter(t -> t.getType().equals(
            TransactionType.INCOME)).collect(Collectors.toList());

    List<StatDto> stats = new ArrayList<>();

    // only incoming category type
    for (var category = 0; category < CategoryType.values().length - 1; category++) {
      CategoryType type = CategoryType.values()[category];
      List<TransactionDto> temp = transactions.stream().filter(t -> t.getCategory().equals(type))
          .collect(
              Collectors.toList());
      StatDto newStat = StatDto.builder()
          .accountId(account.getId())
          .category(type)
          .percent((temp.size() / transactions.size()) * 100)
          .type(TransactionType.INCOME)
          .build();
      stats.add(newStat);
    }
    return stats;
  }

  @Transactional
  public BigInteger getIncome(UUID userId, LocalDateTime startDate,
      LocalDateTime endDate) {
    AccountDto account = this.client.getAccount(userId);
    return this.client
        .getTransactionsByPeriod(account.getId().toString(), startDate, endDate).stream()
        .filter(t -> t.getType().equals(
            TransactionType.INCOME)).map(TransactionDto::getAmount).reduce(BigInteger::add).get();
  }

  @Transactional
  public BigInteger getExpenses(UUID userId, LocalDateTime startDate,
      LocalDateTime endDate) {
    AccountDto account = this.client.getAccount(userId);
    return this.client
        .getTransactionsByPeriod(account.getId().toString(), startDate, endDate).stream()
        .filter(t -> t.getType().equals(
            TransactionType.EXPENSE)).map(TransactionDto::getAmount).reduce(BigInteger::add).get();

  }

}
