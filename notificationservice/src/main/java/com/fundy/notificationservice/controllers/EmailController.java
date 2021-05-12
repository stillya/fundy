package com.fundy.notificationservice.controllers;

import com.fundy.notificationservice.dto.MailDto;
import com.fundy.notificationservice.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmailController {

  private final EmailService emailService;

  @PostMapping(path = "/send")
  public void sendEmail(@RequestBody MailDto mail) {
    this.emailService.send(mail);
  }

}
