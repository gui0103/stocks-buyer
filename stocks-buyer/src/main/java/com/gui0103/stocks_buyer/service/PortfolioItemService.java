package com.gui0103.stocks_buyer.service;

import com.gui0103.stocks_buyer.model.PortfolioItem;
import com.gui0103.stocks_buyer.repository.PortfolioItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioItemService {
    private final PortfolioItemRepository portfolioItemRepository;

    public List<PortfolioItem> getPortfolioItems(Long userId) {
        return portfolioItemRepository.findByUserId(userId);
    }

    public PortfolioItem setPortfolioItem(PortfolioItem item) {
        return portfolioItemRepository.save(item);
    }
}
