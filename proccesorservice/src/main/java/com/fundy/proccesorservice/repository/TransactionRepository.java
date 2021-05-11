package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.TransactionEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, UUID> {

  List<TransactionEntity> getAllByAccountId(UUID id);

  List<TransactionEntity> getAllByAccountIdAndCreationDateBetween(UUID id, LocalDateTime startDate,
      LocalDateTime endDate);

}
