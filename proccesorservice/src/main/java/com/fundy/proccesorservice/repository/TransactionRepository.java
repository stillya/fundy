package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.TransactionEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, UUID> {

}
