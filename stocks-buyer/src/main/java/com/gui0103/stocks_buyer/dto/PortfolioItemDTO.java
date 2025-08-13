package com.gui0103.stocks_buyer.dto;

import com.gui0103.stocks_buyer.model.PortfolioItem;

import java.math.BigDecimal;

public record PortfolioItemDTO(
        Long id,
        Long userId,
        String stockSymbol,
        String stockName,
        int quantity,
        BigDecimal averagePurchasePrice,
        BigDecimal currentValue,
        BigDecimal profitLoss
) {
    public static PortfolioItemDTO fromEntity(PortfolioItem item, BigDecimal currentPrice) {
        BigDecimal currentValue = currentPrice.multiply(BigDecimal.valueOf(item.getQuantity()));
        BigDecimal totalCost = item.getAveragePurchasePrice().multiply(BigDecimal.valueOf(item.getQuantity()));
        BigDecimal profitLoss = currentValue.subtract(totalCost);

        return new PortfolioItemDTO(
                item.getId(),
                item.getUser().getId(),
                item.getStock().getSymbol(),
                item.getStock().getName(),
                item.getQuantity(),
                item.getAveragePurchasePrice(),
                currentValue,
                profitLoss
        );
    }
}