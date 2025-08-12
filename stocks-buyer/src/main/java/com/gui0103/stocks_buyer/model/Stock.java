package com.gui0103.stocks_buyer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    @Id
    private String symbol;  // Natural key
    private String name;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<PortfolioItem> portfolioItems = new ArrayList<>();

    public Stock(String symbol, String name, List<Transaction> transactions, List<PortfolioItem> portfolioItems) {
        this.symbol = symbol;
        this.name = name;
        this.transactions = transactions;
        this.portfolioItems = portfolioItems;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<PortfolioItem> getPortfolioItems() {
        return portfolioItems;
    }

    public void setPortfolioItems(List<PortfolioItem> portfolioItems) {
        this.portfolioItems = portfolioItems;
    }
}
