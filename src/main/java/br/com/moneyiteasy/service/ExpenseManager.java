package br.com.moneyiteasy.service;

import br.com.moneyiteasy.dao.ExpenseDao;
import br.com.moneyiteasy.model.Expense;
import br.com.moneyiteasy.model.Transaction;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public void addTransaction(Scanner scanner) throws SQLException {
        super.addTransaction(scanner);

        Expense expense = (Expense) transactions.get(transactions.size() - 1);

        if (expenseDao.addExpense(expense)) {
            System.out.println("Despesa adicionada com sucesso.");
        } else {
            System.out.println("Erro ao adicionar despesa.");
        }
    }

    @Override
    public void displayTransactions() {
        List<Expense> expenses = expenseDao.getAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
        } else {
            System.out.println("Despesas cadastradas:");
            for (Expense expense : expenses) {
                System.out.printf("Categoria: %s | Valor: R$ %.2f | Data e Hora: %s | Método de pagamento: %s\n",
                        expense.getCategory(), expense.getValue(), expense.getFormattedTimestamp(), expense.getMethod());
            }
            System.out.printf("Total de despesas: R$ %.2f\n", expenseDao.getTotalExpenses());
        }
    }
}
