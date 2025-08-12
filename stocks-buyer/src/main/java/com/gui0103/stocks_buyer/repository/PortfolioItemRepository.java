package com.gui0103.stocks_buyer.repository;

import com.gui0103.stocks_buyer.model.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    List<PortfolioItem> findByUserId(Long userId);
    Optional<PortfolioItem> findByUserIdAndStockSymbol(Long userId, String symbol);
}