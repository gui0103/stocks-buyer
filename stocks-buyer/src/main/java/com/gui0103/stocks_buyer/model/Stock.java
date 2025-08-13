package com.gui0103.stocks_buyer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    private String symbol;  // Natural key
    private String name;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<PortfolioItem> portfolioItems = new ArrayList<>();
}
