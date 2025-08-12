package com.gui0103.stocks_buyer.dto;

import com.gui0103.stocks_buyer.model.User;

import java.math.BigDecimal;

public record UserDTO(
        Long id,
        String name,
        String email,
        BigDecimal balance
) {
    public static UserDTO fromEntity(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBalance()
        );
    }
}