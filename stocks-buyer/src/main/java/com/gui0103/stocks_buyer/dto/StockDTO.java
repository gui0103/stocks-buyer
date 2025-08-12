package com.gui0103.stocks_buyer.dto;

import com.gui0103.stocks_buyer.model.Stock;

import java.math.BigDecimal;

public record StockDTO(
        String symbol,
        String name,
        BigDecimal currentPrice
) {
    public static StockDTO fromEntity(Stock stock, BigDecimal currentPrice) {
        return new StockDTO(
                stock.getSymbol(),
                stock.getName(),
                currentPrice
        );
    }
}