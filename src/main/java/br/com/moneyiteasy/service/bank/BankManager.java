package br.com.moneyiteasy.service.bank;


import br.com.moneyiteasy.dao.BankAccountDao;
import br.com.moneyiteasy.model.BankAccount;
import br.com.moneyiteasy.dao.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankManager {
    private BankAccountDao bankAccountDao = new BankAccountDao();

    public void addBankAccount(Scanner scanner) {
        UserDao userDao = new UserDao();

        System.out.println("Cadastre sua Conta Bancária: ");
        System.out.println("Informe o CPF do Usuário: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        int userId = userDao.getUserIdbyCpf(cpf);

        if(userId > 0) {
            boolean success = false;
            while (!success) {
                try {
                    BankAccount bankAccount = new BankAccount();
                    System.out.println("Nome do Banco:");
                    bankAccount.setNameBank(scanner.nextLine());
                    System.out.println("Número do Banco:");
                    bankAccount.setNumberBank(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Número da Agência:");
                    bankAccount.setAgencyBank(scanner.nextLine());
                    System.out.println("Número da Conta Bancária: (sem digito):");
                    bankAccount.setAccountNumber(scanner.nextLine());
                    System.out.println("Digito da Conta Bancária:");
                    bankAccount.setAccountNumberDigit(scanner.nextLine());
                    bankAccount.setIdUser(userId);

                    if (!isBankExists(bankAccount)) {
                        bankAccountDao.addBankAccount(bankAccount);
                        System.out.println("Conta Cadastrada com sucesso!");
                        success = true;
                    } else {
                        System.out.println("Conta já existente. Tente novamente.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao cadastrar conta: " + e.getMessage());
                }
            }
        } else {
            System.out.println("CPF não cadastrado. Tente novamente.");
        }
    }
    private boolean isBankExists(BankAccount bankAccount) {
        List<BankAccount> bankAccounts = bankAccountDao.getAllUBankAccounts();
        return bankAccounts.stream().anyMatch(u ->
                u.getAccountNumber().equals(bankAccount.getAccountNumber()) &&
                        u.getAccountNumberDigit().equals(bankAccount.getAccountNumberDigit())
        );
    }

    public void displayAllUsersContent() {
        List<BankAccount> bankAccounts = bankAccountDao.getAllUBankAccounts();
        if (!bankAccounts.isEmpty()) {
            for (BankAccount bankAccount : bankAccounts) {
                System.out.println("ID da Conta Bancária: " + bankAccount.getIdBankAccount());
                System.out.println("ID do Usuário: " + bankAccount.getIdUser());
                System.out.println("Nome do Banco: " + bankAccount.getNameBank());
                System.out.println("Nr. Banco: " + bankAccount.getNumberBank());
                System.out.println("Agência: " + bankAccount.getAgencyBank());
                System.out.println("Conta: " + bankAccount.getAccountNumber());
                System.out.println("Digíto: " + bankAccount.getAccountNumberDigit());
                System.out.println("---------------------------------");
            }
        } else {
            System.out.println("Nenhuma conta bancária encontrada.");
        }
    }
}
