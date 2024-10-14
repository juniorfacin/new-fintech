package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ExpenseDao {
    private Connection connection;

    public ExpenseDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }



    public void closeConexao() throws SQLException {
        connection.close();
    }
}
