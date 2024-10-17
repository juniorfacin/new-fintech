package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.Investment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvestmentDao {
    private Connection connection;

    public boolean addInvestment(Investment investment) {
        String sql = "INSERT INTO t_investment (id_transaction, vl_invested, ds_investment, id_investment_category, id_user)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt (1, investment.getIdTransaction());
            statement.setDouble (2, investment.getInvestmentValue());
            statement.setString (3, investment.getInvestmentNote());
            statement.setInt (4, investment.getInvestmentCategory());
            statement.setInt (5, investment.getIdUser());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o investimento: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteInvestment(int idTransaction) {
        String sql = "DELETE FROM t_investment WHERE id_transaction = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTransaction);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao apagar o investimento: " + e.getMessage());
            return false;
        }
    }

    public List<Investment> getAllInvestments() {
        String sql = "SELECT * FROM t_investment";
        List<Investment> investments = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idTransaction = resultSet.getInt("id_transaction");
                int investmentValue = resultSet.getInt("vl_invested");
                String investmentNote = resultSet.getString("ds_investment");
                int investmentCategory = resultSet.getInt("id_investment_category");
                int idUser = resultSet.getInt("id_user");
                Investment investment = new Investment(idTransaction, investmentValue, investmentNote, investmentCategory, idUser);
                investments.add(investment);
            }
            return investments;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar os investimentos no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }
}