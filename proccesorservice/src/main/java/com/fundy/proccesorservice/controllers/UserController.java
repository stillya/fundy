package com.fundy.proccesorservice.controllers;

import com.fundy.commons.dto.AccountDto;
import com.fundy.commons.dto.UserDto;
import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.dto.UserCreateDto;
import com.fundy.proccesorservice.services.crud.UsersCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

  private final UsersCrudService usersCrudService;

  @PostMapping
  public UserDto createUser(@RequestBody UserCreateDto userCreateDto) {
    return this.usersCrudService.createUser(userCreateDto);
  }

}
