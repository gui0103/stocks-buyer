package com.gui0103.stocks_buyer.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record TransactionRequest(
        @NotNull(message = "User ID is required")
        Long userId,

        @NotBlank(message = "Stock symbol is required")
        @Size(min = 1, max = 10, message = "Symbol must be 1-10 characters")
        String stockSymbol,

        @Min(value = 1, message = "Quantity must be at least 1")
        int quantity,

        @Positive BigDecimal price,

        @Pattern(regexp = "BUY|SELL", message = "Type must be BUY or SELL")
        String type
) {}