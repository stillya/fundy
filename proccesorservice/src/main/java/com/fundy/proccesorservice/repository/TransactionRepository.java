package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.TransactionEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, UUID> {

  List<TransactionEntity> getAllByAccountId(UUID id);

  List<TransactionEntity> getAllByAccountIdAndCreationDateBetweenOrderByCreationDate(UUID id, LocalDateTime startDate,
      LocalDateTime endDate);

  @Query(nativeQuery = true, value = "SELECT * FROM Transactions t WHERE t.account_id = ?1 ORDER BY t.amount ASC LIMIT ?2 OFFSET ?3")
  List<TransactionEntity> getAllByAccountIdWithOffset(UUID id, int limit, int offset);
}
