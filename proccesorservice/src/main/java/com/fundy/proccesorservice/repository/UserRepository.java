package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.UserEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<UserEntity, UUID> {

}
