package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DataHorarioDao {
    private Connection connection;

    public DataHorarioDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConexao() throws SQLException {
        connection.close();
    }
}
