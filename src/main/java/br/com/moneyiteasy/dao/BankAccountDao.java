package br.com.moneyiteasy.dao;

import br.com.moneyiteasy.factory.ConnectionFactory;
import br.com.moneyiteasy.model.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccountDao {

    private Connection connection;

    public boolean addBankAccount(BankAccount bankAccount) {
        String sql = "INSERT INTO t_bank_account (id_user, nm_bank, nr_bank, nr_agency, nr_account, nr_account_digit)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt (1, bankAccount.getIdUser());
            statement.setString (2, bankAccount.getNameBank());
            statement.setInt (3, bankAccount.getNumberBank());
            statement.setString (4, bankAccount.getAgencyBank());
            statement.setString (5, bankAccount.getAccountNumber());
            statement.setString (6, bankAccount.getAccountNumberDigit());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir a Conta Bancária: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteBankAccount(String accountNumber) {
        String sql = "DELETE FROM t_bank_account WHERE nr_account = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, accountNumber);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao apagar a Conta Bancária: " + e.getMessage());
            return false;
        }
    }

    public List<BankAccount> getAllUBankAccounts() {
        String sql = "SELECT * FROM t_bank_account";
        List<BankAccount> bankAccounts = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idBankAccount = resultSet.getInt("id_bank_account");
                int idUser = resultSet.getInt("id_user");
                String nameBank = resultSet.getString("nm_bank");
                int numberBank = resultSet.getInt("nr_bank");
                String agencyBank = resultSet.getString("nr_agency");
                String accountNumber = resultSet.getString("nr_account");
                String accountNumberDigit = resultSet.getString("nr_account_digit");
                BankAccount bankAccount = new BankAccount(idBankAccount, idUser, nameBank, numberBank, agencyBank,
                        accountNumber, accountNumberDigit);
                bankAccounts.add(bankAccount);
            }
            return bankAccounts;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar os usuários no banco: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<BankAccount> getBankAccountsByUserId(int userId) {
        String sql = "SELECT * FROM t_bank_account WHERE id_user = ?";
        List<BankAccount> bankAccounts = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idBankAccount = resultSet.getInt("id_bank_account");
                    String nameBank = resultSet.getString("nm_bank");
                    int numberBank = resultSet.getInt("nr_bank");
                    String agencyBank = resultSet.getString("nr_agency");
                    String accountNumber = resultSet.getString("nr_account");
                    String accountNumberDigit = resultSet.getString("nr_account_digit");
                    BankAccount bankAccount = new BankAccount(idBankAccount, userId, nameBank, numberBank,
                            agencyBank, accountNumber, accountNumberDigit);
                    bankAccounts.add(bankAccount);
                }
            }
            return bankAccounts;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar as Contas Bancárias : " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
