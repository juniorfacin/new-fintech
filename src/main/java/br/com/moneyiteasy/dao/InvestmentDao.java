package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class InvestmentDao {
    private Connection conexao;

    public InvestmentDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void closeConexao() throws SQLException {
        conexao.close();
    }
}
