package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private Connection connection;

    public boolean addUser(User user) {
        String sql = "INSERT INTO usuario (name, email, cpf, password) " +
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
}
