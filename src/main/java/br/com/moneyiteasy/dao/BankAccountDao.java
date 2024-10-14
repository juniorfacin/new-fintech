package br.com.moneyiteasy.dao;
import br.com.moneyiteasy.exception.EntityNotFoundException;
import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.BankAccount;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BankAccountDao {

    private Connection conexao;

    public BankAccountDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

//    public void register(BankAccount bankAccount) throws SQLException {
//        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ");
//        stmt.setString(1, bankAccount.getNameBank());
//        .....
//        stmt.executeUpdate();
//    }

    public void closeConexao() throws SQLException {
        conexao.close();
    }

//    public BankAccount findBankAccount(long userId) throws SQLException, EntityNotFoundException {
//        PreparedStatement stmt = conexao.prepareStatement("select * from ");
//
//    }
}