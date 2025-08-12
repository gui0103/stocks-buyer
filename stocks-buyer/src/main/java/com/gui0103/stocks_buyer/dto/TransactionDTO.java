package com.gui0103.stocks_buyer.dto;

import com.gui0103.stocks_buyer.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        Long id,
        Long userId,
        String stockSymbol,
        int quantity,
        BigDecimal price,
        String type,
        LocalDateTime timestamp
) {
    public static TransactionDTO fromEntity(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getStock().getSymbol(),
                transaction.getQuantity(),
                transaction.getPrice(),
                transaction.getBuyOrSell(),
                transaction.getTimestamp()
        );
    }
}