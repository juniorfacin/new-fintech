package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionDao {
    private Connection connection;

    public boolean addTransaction(Transaction transaction) {
        String sql = "INSERT INTO t_transaction (id_transaction, id_user, dt_transaction)" +
                "VALUES (?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt (1, transaction.getIdTransaction());
            statement.setInt (2, transaction.getIdUser());
            statement.setDate(3, java.sql.Date.valueOf(transaction.getTransactionDate()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o investimento: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteTransaction(int idTransaction) {
        String sql = "DELETE FROM t_transaction WHERE id_transaction = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTransaction);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao apagar a transação: " + e.getMessage());
            return false;
        }
    }

    public List<Transaction> getAllTransactions() {
        String sql = "SELECT * FROM t_transaction";
        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idTransaction = resultSet.getInt("id_transaction");
                int idUser = resultSet.getInt("id_user");
                LocalDate transactionDate = resultSet.getDate("dt_transaction").toLocalDate();
                Transaction transaction = new Transaction(idTransaction, idUser, transactionDate) {};
                transactions.add(transaction);
            }
            return transactions;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar a transação no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }
}