package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.AccountEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

interface AccountRepository extends CrudRepository<AccountEntity, UUID> {

}
