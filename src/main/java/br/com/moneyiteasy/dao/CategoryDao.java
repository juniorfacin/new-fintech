package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.Category;

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
        String sql = "INSERT INTO t_expense_category (ds_expense_category) VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getCategoryName().toUpperCase());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria de despesas no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteExpenseCategory(String category) throws SQLException {
        String sql = "DELETE FROM t_expense_category WHERE ds_expense_category = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao remover a categoria de despesas do banco: " + e.getMessage());
            return false;
        }
    }

    public List<Category> getAllExpenseCategory() {
        String sql = "SELECT * FROM t_expense_category";
        List<Category> categories = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_expense_category");
                String name = resultSet.getString("ds_expense_category");
                Category category = new Category(id, name);
                categories.add(category);
            }
            return categories;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar categorias de despesas no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public boolean addInvestmentCategory(Category category) throws SQLException {
        String sql = "INSERT INTO t_investment_category (ds_investment_category) VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getCategoryName());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a categoria de investimentos no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteInvestmentCategory(String category) throws SQLException {
        String sql = "DELETE FROM t_investment_category WHERE ds_investment_category = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao remover a categoria de investimentos do banco: " + e.getMessage());
            return false;
        }
    }

    public List<Category> getAllInvestmentCategory() {
        String sql = "SELECT * FROM t_investment_category";
        List<Category> categories = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_investment_category");
                String name = resultSet.getString("ds_investment_category");
                Category category = new Category(id, name);
                categories.add(category);
            }
            return categories;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar categorias de investimentos no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public int getExpenseCategoryIdbyName (String categoryName) throws SQLException {
        String sql = "SELECT id_expense_category FROM t_expense_category WHERE ds_expense_category = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoryName);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return resultSet.getInt("id_expense_category");
                } else {
                    return -1;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar a categoria: " + e.getMessage());
            return -1;
        }
    }
}