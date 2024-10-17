package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.Revenue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RevenueDao {
    private Connection connection;

    public boolean addRevenue(Revenue revenue) {
        String sql = "INSERT INTO t_revenue (id_transaction, id_expense_category, vl_expense_value, ds_revenue, id_user)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt (1, revenue.getIdTransaction());
            statement.setInt (2, revenue.getRevenueCategory());
            statement.setInt(3, revenue.getIdRevenueOrigin());
            statement.setDouble (4, revenue.getRevenueValue());
            statement.setString (5, revenue.getRevenueNote());
            statement.setInt (6, revenue.getIdUser());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a : " + e.getMessage());
            return false;
        }
    }

    public boolean deleteRevenue(int idTransaction ) {
        String sql = "DELETE FROM t_revenue WHERE -escolher- = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTransaction);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao apagar a receita: " + e.getMessage());
            return false;
        }
    }

    public List<Revenue> getAllRevenue() {
        String sql = "SELECT * FROM t_revenue";
        List<Revenue> revenues = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idTransaction = resultSet.getInt("id_transaction");
                int revenueCategory = resultSet.getInt("id_revenue_category");
                int idRevenueOrigin = resultSet.getInt("id_revenue_origin");
                double revenueValue = resultSet.getDouble("vl_revenue");
                String revenueNote = resultSet.getString("ds_revenue");
                int idUser = resultSet.getInt("id_user");
                Revenue revenue = new Revenue(idTransaction, revenueCategory, idRevenueOrigin, revenueValue,
                        revenueNote, idUser);
                revenues.add(revenue);
            }
            return revenues;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar as receitas no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }
}