package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionDao {
    private Connection connection;

    public TransactionDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }
}
