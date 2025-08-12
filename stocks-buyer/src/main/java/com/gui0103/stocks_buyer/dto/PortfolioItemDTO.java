package com.gui0103.stocks_buyer.dto;

import com.gui0103.stocks_buyer.model.PortfolioItem;

import java.math.BigDecimal;

public record PortfolioItemDTO(
        Long id,
        Long userId,
        String stockSymbol,
        int quantity,
        BigDecimal averagePurchasePrice,
        BigDecimal currentValue
) {
    public static PortfolioItemDTO fromEntity(PortfolioItem item, BigDecimal currentPrice) {
        return new PortfolioItemDTO(
                item.getId(),
                item.getUser().getId(),
                item.getStock().getSymbol(),
                item.getQuantity(),
                item.getAveragePurchasePrice(),
                currentPrice.multiply(BigDecimal.valueOf(item.getQuantity()))
        );
    }
}