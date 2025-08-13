package com.gui0103.stocks_buyer.controller;

import com.gui0103.stocks_buyer.dto.StockDTO;
import com.gui0103.stocks_buyer.model.Stock;
import com.gui0103.stocks_buyer.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping
    public List<StockDTO> getStocks() {
        return stockService.getStocks().stream()
                .map(stock -> StockDTO.fromEntity(stock, stockService.getCurrentPrice(stock.getSymbol())))
                .toList();
    }

    @GetMapping("/{symbol}")
    public StockDTO getStockBySymbol(@PathVariable String symbol) {
        Stock stock = stockService.getStockBySymbol(symbol);
        return StockDTO.fromEntity(stock, stockService.getCurrentPrice(symbol));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDTO createStock(@RequestBody Stock stock) {
        return StockDTO.fromEntity(
                stockService.setStock(stock),
                stockService.getCurrentPrice(stock.getSymbol())
        );
    }
}
