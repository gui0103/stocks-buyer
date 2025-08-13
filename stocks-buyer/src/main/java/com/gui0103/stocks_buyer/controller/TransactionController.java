package com.gui0103.stocks_buyer.controller;

import com.gui0103.stocks_buyer.dto.TransactionDTO;
import com.gui0103.stocks_buyer.model.Stock;
import com.gui0103.stocks_buyer.model.Transaction;
import com.gui0103.stocks_buyer.model.User;
import com.gui0103.stocks_buyer.request.TransactionRequest;
import com.gui0103.stocks_buyer.service.StockService;
import com.gui0103.stocks_buyer.service.TransactionService;
import com.gui0103.stocks_buyer.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;
    private final StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO createTransaction(
            @Valid @RequestBody TransactionRequest request) {

        Transaction transaction = mapRequestToTransaction(request);
        Transaction savedTransaction = transactionService.createTransaction(transaction);
        return TransactionDTO.fromEntity(savedTransaction);
    }

    private Transaction mapRequestToTransaction(TransactionRequest request) {
        User user = userService.getUserById(request.userId());
        Stock stock = stockService.getStockBySymbol(request.stockSymbol());

        return Transaction.builder()
                .user(user)
                .stock(stock)
                .quantity(request.quantity())
                .price(request.price())
                .buyOrSell(request.type())
                .timestamp(LocalDateTime.now())
                .build();
    }
}