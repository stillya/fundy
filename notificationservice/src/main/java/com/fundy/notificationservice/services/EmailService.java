package com.fundy.notificationservice.services;

import com.fundy.commons.clients.AccountClient;
import com.fundy.commons.dto.TransactionDto;
import com.fundy.commons.types.NotificationPeriodType;
import com.fundy.notificationservice.dto.MailDto;
import com.fundy.notificationservice.utils.MessageHelper;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final AccountClient accountClient;
  private final JavaMailSender emailSender;

  private static final String SOURCE_ADDRESS = "noreply@fundy.com";
  private static final String SUBJECT = "STATISTIC FROM FUNDY";

  public void send(MailDto mailDto) {
    List<TransactionDto> transactions = this.accountClient
        .getTransactionsByPeriod(mailDto.getAccountId(), this.getTime(mailDto.getType(),
            mailDto.getPeriod()), LocalDateTime.now());

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(SOURCE_ADDRESS);
    message.setTo(mailDto.getEmail());
    message.setSubject(SUBJECT);
    message.setText(MessageHelper.NoHTMLTransactionsMessage(transactions));

    this.emailSender.send(message);
  }

  private LocalDateTime getTime(NotificationPeriodType period, int time) {
    if (period.equals(NotificationPeriodType.MONTH)) {
      return LocalDateTime.from(ZonedDateTime.now().minusMonths(time));
    } else {
      return LocalDateTime.from(ZonedDateTime.now().minusDays(time));
    }
  }

}
