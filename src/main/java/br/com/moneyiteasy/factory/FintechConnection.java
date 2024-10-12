package br.com.moneyiteasy.factory;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.moneyiteasy.factory.ConnectionFactory;


public class FintechConnection {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
