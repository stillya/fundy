package com.fundy.proccesorservice.services.crud;

import com.fundy.commons.dto.UserDto;
import com.fundy.proccesorservice.dto.UserCreateDto;
import com.fundy.proccesorservice.mappers.UserMapper;
import com.fundy.proccesorservice.repository.UserRepository;
import com.fundy.proccesorservice.utils.ConverterHelper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersCrudService {

  private final UserRepository userRepository;

  public List<UserDto> getUsers() {
    return this.userRepository.findAll().stream().map(UserMapper.INSTANCE::toDto)
        .collect(
            Collectors.toList());
  }

  @Transactional
  public UserDto createUser(UserCreateDto dto) {
    return UserMapper.INSTANCE
        .toDto(this.userRepository.save(ConverterHelper.UserCreateDtoUserEntity(dto)));
  }

}
