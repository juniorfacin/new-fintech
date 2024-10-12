package br.com.moneyiteasy.service.transaction;

import br.com.moneyiteasy.model.transaction.Expense;
import br.com.moneyiteasy.model.transaction.Transaction;

import java.time.LocalDateTime;

public class ExpenseManager extends TransactionManager {

    @Override
    protected String getTransactionType() {
        return "despesa";
    }

    @Override
    protected Transaction createTransaction(String category, double value, LocalDateTime timestamp, String method) {
        return new Expense(category, value, timestamp, method, false);
    }
}
