package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {
    private Connection connection;

    public boolean addUser(User user) {
        String sql = "INSERT INTO t_user (id_user, nm_user, tx_email, nr_cpf, tx_password, dt_creation, vl_balance)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt (1, user.getId());
            statement.setString (2, user.getName());
            statement.setString (3, user.getEmail());
            statement.setString (4, user.getCpf());
            statement.setString (5, user.getPassword());
            statement.setDate (6, java.sql.Date.valueOf(user.getDate()));
            statement.setDouble (7, user.getBalance());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o usuario no banco: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(User user) {
        String sql = "DELETE FROM t_user WHERE (nr_cpf) " +
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
                int id = resultSet.getInt("id_user");
                String name = resultSet.getString("nm_user");
                String email = resultSet.getString("tx_email");
                String cpf = resultSet.getString("nr_cpf");
                String password = resultSet.getString("tx_password");
                LocalDate date = resultSet.getDate("dt_creation").toLocalDate();
                double balance = resultSet.getDouble("vl_balance");
                User user = new User(id, name, email, cpf, password, date, balance);
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
