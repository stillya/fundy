package com.fundy.notificationservice.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceConfiguration {

  @Value("${spring.mail.host}")
  String host;
  @Value("${spring.mail.port}")
  int port;
  @Value("${spring.mail.username}")
  String username;
  @Value("${spring.mail.password}")
  String password;

  @Bean
  public JavaMailSender getJavaMailSender() {
    var mailSender = new JavaMailSenderImpl();

    mailSender.setHost(host);
    mailSender.setPort(port);
    mailSender.setUsername(username);
    mailSender.setPassword(password);

    var props = mailSender.getJavaMailProperties();

    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
  }

}
