package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.transaction.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDao {
    private Connection connection;

    public boolean addExpenseCategory(Category category) throws SQLException {
        String sql = "INSERT INTO t_expense_category (description) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, category.getCategoryName());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteExpenseCategory(Category category) throws SQLException {
        String sql = "DELETE FROM t_expense_category WHERE (description) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, category.getCategoryName());
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria no banco: " + e.getMessage());
            return false;
        }
    }

    public List<Category> getAllExpenseCategory() {
        String sql = "SELECT * FROM t_expense_category";
        List<Category> categorys = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                Category category = new Category(nome);
                categorys.add(category);
            }
            return categorys;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar as categorias de gastos no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public boolean addRevenueCategory(Category category) throws SQLException {
        String sql = "INSERT INTO t_revenue_category (description) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, category.getCategoryName());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteRevenueCategory(Category category) throws SQLException {
        String sql = "DELETE FROM t_revenue_category WHERE (description) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, category.getCategoryName());
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria no banco: " + e.getMessage());
            return false;
        }
    }

    public List<Category> getAllRevenueCategory() {
        String sql = "SELECT * FROM t_revenue_category";
        List<Category> categorys = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                Category category = new Category(nome);
                categorys.add(category);
            }
            return categorys;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar as categorias de gastos no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public boolean addInvestmentCategory(Category category) throws SQLException {
        String sql = "INSERT INTO t_investment_category (description) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, category.getCategoryName());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteInvestmentCategory(Category category) throws SQLException {
        String sql = "DELETE FROM t_investiment_category WHERE (description) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, category.getCategoryName());
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria no banco: " + e.getMessage());
            return false;
        }
    }

    public List<Category> getAllInvestmentCategory() {
        String sql = "SELECT * FROM t_investiment_category";
        List<Category> categorys = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                Category category = new Category(nome);
                categorys.add(category);
            }
            return categorys;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar as categorias de gastos no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }



    public void closeConexao() throws SQLException {
        connection.close();
    }
}
