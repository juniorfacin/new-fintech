package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.transaction.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseDao {

    private Connection connection;

    public boolean addExpense(Expense expense) {
        String sql = "INSERT INTO t_expense (id_transaction, id_expense_category, vl_expense_value, ds_expense_note, id_user)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt (1, expense.getIdTransaction());
            statement.setInt (2, expense.getExpenseCategory());
            statement.setDouble (3, expense.getValue());
            statement.setString (4, expense.getExpenseNote());
            statement.setInt (5, expense.getIdUser());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a Conta Bancária: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteExpense(int idTransaction) {
        String sql = "DELETE FROM t_expense WHERE id_transaction = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTransaction);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao apagar despesa: " + e.getMessage());
            return false;
        }
    }

    public List<Expense> getAllExpenses() {
        String sql = "SELECT * FROM t_expense";
        List<Expense> expenses = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idTransaction = resultSet.getInt("id_transaction");
                int expenseCategory = resultSet.getInt("expense_category");
                double expenseValue = resultSet.getDouble("vl_expense_value");
                String expenseNote = resultSet.getString("expense_note");
                int idUser = resultSet.getInt("id_user");
                Expense expense = new Expense(idTransaction, expenseCategory, expenseValue, expenseNote, idUser);
                expenses.add(expense);
            }
            return expenses;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar os gastos no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }

}