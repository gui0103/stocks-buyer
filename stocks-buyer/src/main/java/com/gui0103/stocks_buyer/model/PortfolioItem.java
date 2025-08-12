package com.gui0103.stocks_buyer.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_symbol")
    private Stock stock;

    private int quantity;
    private BigDecimal averagePurchasePrice;

    public PortfolioItem(Long id, User user, Stock stock, int quantity, BigDecimal averagePurchasePrice) {
        this.id = id;
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.averagePurchasePrice = averagePurchasePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAveragePurchasePrice() {
        return averagePurchasePrice;
    }

    public void setAveragePurchasePrice(BigDecimal averagePurchasePrice) {
        this.averagePurchasePrice = averagePurchasePrice;
    }
}
