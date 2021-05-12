package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.AccountEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

  List<AccountEntity> findAll();

  AccountEntity getById(UUID id);

  AccountEntity getByUserId(UUID userId);

}
