package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {

    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO t_user (nm_user, tx_email, nr_cpf, tx_password, dt_creation)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCpf());
            statement.setString(4, user.getPassword());
            statement.setDate(5, java.sql.Date.valueOf(user.getDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar usuário: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteUser(String cpf) {
        String sql = "DELETE FROM t_user WHERE nr_cpf = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cpf);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o usuário no banco: " + e.getMessage());
            return false;
        }
    }

    public List<User> getAllUserTable() {
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
                User user = new User(id, name, email, cpf, password, date);
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar os usuários no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<User> getUserNamesAndCpfs() {
        String sql = "SELECT nm_user, nr_cpf, tx_email FROM t_user";
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("nm_user");
                String cpf = resultSet.getString("nr_cpf");
                String email = resultSet.getString("tx_email");
                User user = new User(name, cpf, email);
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar os nomes e CPFs dos usuários no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
