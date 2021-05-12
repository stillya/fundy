package com.fundy.proccesorservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundy.commons.dto.AccountDto;
import com.fundy.commons.dto.UserDto;
import com.fundy.proccesorservice.dto.AccountCreateDto;
import com.fundy.proccesorservice.dto.UserCreateDto;
import com.fundy.proccesorservice.services.crud.AccountCrudService;
import com.fundy.proccesorservice.services.crud.UsersCrudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class ProcessingServiceApplicationTests {

  @Autowired
  private MockMvc mvc;
  @Autowired
  private UsersCrudService usersCrudService;
  @Autowired
  private AccountCrudService accountCrudService;
  @Autowired
  private ObjectMapper mapper;

  @Test
  public void getAccount_thenStatus200() throws Exception {
    // create user
    this.usersCrudService.createUser(UserCreateDto.builder().name("test").build());
    UserDto user = this.usersCrudService.getUsers().get(0);
    // create account
    AccountDto createdAccount = this.accountCrudService.createAccount(AccountCreateDto.builder()
        .name("test")
        .description("test")
        .userId(user.getId())
        .build());
    // get account
    MvcResult result = mvc.perform(get("/process/" + user.getId())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();

    AccountDto account = this.mapper
        .readValue(result.getResponse().getContentAsString(), AccountDto.class);

    Assertions.assertEquals(createdAccount.getId(), account.getId());
    Assertions.assertEquals(createdAccount.getBalance(), account.getBalance());
    Assertions.assertEquals(createdAccount.getName(), account.getName());
    Assertions.assertEquals(createdAccount.getDescription(), account.getDescription());
    Assertions.assertEquals(createdAccount.getUser(), account.getUser());
  }

}
