package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.AccountEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

  AccountEntity getByUserId(UUID userId);

}
