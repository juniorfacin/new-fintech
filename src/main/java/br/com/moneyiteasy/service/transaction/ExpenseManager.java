package br.com.moneyiteasy.service.transaction;

import br.com.moneyiteasy.dao.ExpenseDao;
import br.com.moneyiteasy.model.transaction.Expense;
import br.com.moneyiteasy.model.transaction.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class ExpenseManager extends TransactionManager {
    ExpenseDao expenseDao = new ExpenseDao();
    @Override
    protected String getTransactionType() {
        return "despesa";
    }

    @Override
    protected Transaction createTransaction(String category, double value, LocalDateTime timestamp, String method) {
        return new Expense(category, value, timestamp, method, false);
    }

    public void displayTransactions() {
        List<Expense> expenses = expenseDao.getAllExpenses(); // Usando o DAO para buscar despesas
        if (expenses.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
        } else {
            System.out.println("Despesas cadastradas:");
            for (Expense expense : expenses) {
                System.out.printf("Categoria: %s | Valor: R$ %.2f | Data e Hora: %s | Método de pagamento: %s\n",
                        expense.getCategory(), expense.getValue(), expense.getFormattedTimestamp(), expense.getMethod());
            }
            System.out.printf("Total de despesas: R$ %.2f\n", getTotalValue());
        }
    }


}
