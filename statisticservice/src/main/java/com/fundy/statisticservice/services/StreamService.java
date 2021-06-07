package com.fundy.statisticservice.services;

import com.fundy.commons.clients.AccountClient;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Service
@RequiredArgsConstructor
public class StreamService {

  private final AccountClient accountClient;

  private static final int PAGE_SIZE = 200;

  public StreamingResponseBody getTransactionsStream(UUID accountId) {
    long transactionsSize = this.accountClient.count(accountId);

    return response -> {
      for (var pageNumber = 0; pageNumber < transactionsSize; pageNumber++) {
        var result = accountClient
            .getLimitedTransactionsWithOffset(accountId, PAGE_SIZE, pageNumber * PAGE_SIZE)
            .toString();
        response.write(result.getBytes(StandardCharsets.UTF_8));
        response.flush();
      }
    };
  }

}
