package com.gui0103.stocks_buyer.service;

import com.gui0103.stocks_buyer.model.Stock;
import com.gui0103.stocks_buyer.repository.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    // External API client
    //private final StockApiClient stockApiClient;

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockBySymbol(String symbol) {
        return stockRepository.findById(symbol)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found"));
    }

    public Stock setStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void setStockName(String symbol, String name) {
        Stock stock = getStockBySymbol(symbol);
        stock.setName(name);
        stockRepository.save(stock);
    }

    // External API
    //public BigDecimal getCurrentPrice(String symbol) {
    //    return stockApiClient.getCurrentPrice(symbol);
    //}
}