package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ExpenseDao {
    private Connection conexao;

    public ExpenseDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void closeConexao() throws SQLException {
        conexao.close();
    }
}
