package com.fundy.notificationservice.utils;

import com.fundy.commons.dto.TransactionDto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class MessageHelper {

  public static String NoHTMLTransactionsMessage(List<TransactionDto> transactions) {
    return StringUtils.join(transactions, ',');
  }

}
