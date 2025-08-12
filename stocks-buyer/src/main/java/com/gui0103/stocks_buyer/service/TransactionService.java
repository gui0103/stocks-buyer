package com.gui0103.stocks_buyer.service;

import com.gui0103.stocks_buyer.model.Transaction;
import com.gui0103.stocks_buyer.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final StockService stockService;
    private final PortfolioItemService portfolioService;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        // Business logic for processing transactions
        // Update user balance and portfolio
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getUserTransactions(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}
