package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.transaction.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {

    private Connection connection;

    public boolean addExpense(Expense expense) {
        String sql = "INSERT INTO t_expense (id_expense_category, vl_expense_value, ds_expense_note, id_user, dt_transaction)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, expense.getExpenseCategory());  // Supondo que você tem uma categoria de despesa associada
            statement.setDouble(2, expense.getValue());
            statement.setString(3, expense.getExpenseNote());
            statement.setInt(4, expense.getIdUser());  // ID do usuário associado à despesa
            statement.setDate(5, java.sql.Date.valueOf(expense.getTimestamp().toLocalDate()));  // Convertendo para o formato SQL
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteExpense(int idExpense) {
        String sql = "DELETE FROM t_expense WHERE id_expense = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idExpense);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao apagar despesa: " + e.getMessage());
            return false;
        }
    }

    public double getTotalExpenses() {
        String sql = "SELECT SUM(vl_expense_value) as total FROM t_expense";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao calcular o total das despesas: " + e.getMessage());
        }
        return 0.0;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT id_expense, id_expense_category, vl_expense_value, ds_expense_note, id_user, dt_transaction FROM t_expense";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idExpense = resultSet.getInt("id_expense");
                String category = resultSet.getString("id_expense_category");
                double value = resultSet.getDouble("vl_expense_value");
                String note = resultSet.getString("ds_expense_note");
                int idUser = resultSet.getInt("id_user");
                LocalDateTime timestamp = resultSet.getTimestamp("dt_transaction").toLocalDateTime();

                Expense expense = new Expense(idExpense, category, value, note, idUser);
                expense.setIdTransaction(idExpense);
                expenses.add(expense);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar despesas: " + e.getMessage());
        }
        return expenses;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
