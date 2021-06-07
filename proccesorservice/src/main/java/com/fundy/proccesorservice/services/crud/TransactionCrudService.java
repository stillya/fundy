package com.fundy.proccesorservice.services.crud;

import com.fundy.commons.dto.TransactionDto;
import com.fundy.proccesorservice.dto.TransactionCreateDto;
import com.fundy.proccesorservice.mappers.TransactionMapper;
import com.fundy.proccesorservice.repository.TransactionRepository;
import com.fundy.proccesorservice.utils.ConverterHelper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionCrudService {

  private final TransactionRepository transactionRepository;

  public List<TransactionDto> getTransactions(UUID accountId) {
    return this.transactionRepository.getAllByAccountId(accountId).stream()
        .map(TransactionMapper.INSTANCE::toDto).collect(
            Collectors.toList());
  }

  public List<TransactionDto> getTransactionsByPeriod(UUID accountId, LocalDateTime startDate,
      LocalDateTime endDate) {
    return this.transactionRepository
        .getAllByAccountIdAndCreationDateBetweenOrderByCreationDate(accountId, startDate, endDate)
        .stream()
        .map(TransactionMapper.INSTANCE::toDto).collect(
            Collectors.toList());
  }

  public List<TransactionDto> getLimitedTransactionsWithOffset(UUID accountId, int limit,
      int offset) {
    return this.transactionRepository
        .getAllByAccountIdWithOffset(accountId, limit, offset).stream()
        .map(TransactionMapper.INSTANCE::toDto).collect(
            Collectors.toList());
  }

  @Transactional
  public TransactionDto createTransaction(TransactionCreateDto dto) {
    return TransactionMapper.INSTANCE.toDto(this.transactionRepository
        .save(ConverterHelper.TransactionCreateDtoTransactionEntity(dto)));
  }

  public long count(UUID accountId) {
    return this.transactionRepository.count();
  }

}
