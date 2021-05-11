package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.AccountEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, UUID> {

  List<AccountEntity> getAll();
  AccountEntity getById(UUID id);
  AccountEntity getByUserId(UUID userId);

}
