package com.gui0103.stocks_buyer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private BigDecimal balance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PortfolioItem> portfolioItems = new ArrayList<>();

    public User(Long id, String name, String email, String password, BigDecimal balance, List<Transaction> transactions, List<PortfolioItem> portfolioItems) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.transactions = transactions;
        this.portfolioItems = portfolioItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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