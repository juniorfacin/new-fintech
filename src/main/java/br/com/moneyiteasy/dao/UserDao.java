package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {
    private Connection connection;

    public boolean addUser(User user) {
        String sql = "INSERT INTO t_user (name, email, cpf, password) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (1, user.getName());
            statement.setString (2, user.getEmail());
            statement.setString (3, user.getCpf());
            statement.setString (4, user.getPassword());
            statement.setString (5, user.getDate());
            statement.setString (6, user.getBalance());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o usuario no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(User user) {
        String sql = "DELETE FROM t_user WHERE (cpf) " +
                "VALUES (?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString (3, user.getCpf());
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o usuario no banco: " + e.getMessage());
            return false;
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM t_user";
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String password = resultSet.getString("password");
                User user = new User(nome, email, cpf, password);
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar os usuários no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }

}
