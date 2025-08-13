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
    private final UserService userService;
    private final StockService stockService;
    private final TransactionRepository transactionRepository;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        // 1. Validar transação
        //validateTransaction(transaction);

        // 2. Salvar transação
        Transaction saved = transactionRepository.save(transaction);

        // 3. Atualizar portfólio
        //portfolioItemService.updatePortfolio(saved);

        return saved;
    }

//    private void processTransactionEffects(User user, Transaction transaction) {
//        BigDecimal totalAmount = transaction.getPrice()
//                .multiply(BigDecimal.valueOf(transaction.getQuantity()));
//
//        if ("BUY".equals(transaction.getBuyOrSell())) {
//            // Verificar saldo suficiente
//            if (user.getBalance().compareTo(totalAmount) < 0) {
//                throw new InsufficientFundsException(user.getBalance(), totalAmount);
//            }
//            user.setBalance(user.getBalance().subtract(totalAmount));
//        } else {
//            user.setBalance(user.getBalance().add(totalAmount));
//        }
//
//        // Atualizar portfólio (implementar separadamente)
//        portfolioService.updatePortfolio(user, transaction);
//    }

    public List<Transaction> getTransactions() {
        return List.of();
    }

    public List<Transaction> getUserTransactions(Long userId) {
        return List.of();
    }
}