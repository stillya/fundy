package com.fundy.proccesorservice.repository;

import com.fundy.proccesorservice.entities.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  List<UserEntity> findAll();

}
