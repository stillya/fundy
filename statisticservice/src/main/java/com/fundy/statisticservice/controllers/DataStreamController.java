package com.fundy.statisticservice.controllers;

import com.fundy.statisticservice.services.StreamService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping(path = "/stream/data")
@RequiredArgsConstructor
@Slf4j
public class DataStreamController {

  private final StreamService streamService;

  @GetMapping(value = "/transactions/{accountId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public ResponseEntity<StreamingResponseBody> getAllStatistic(@PathVariable UUID accountId) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"transactions_" + accountId + ".txt\"")
        .body(this.streamService.getTransactionsStream(accountId));
  }

}
