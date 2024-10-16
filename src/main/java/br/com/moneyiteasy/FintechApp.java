package br.com.moneyiteasy;

import br.com.moneyiteasy.service.bank.BankManager;
import br.com.moneyiteasy.service.transaction.ExpenseManager;
import br.com.moneyiteasy.service.transaction.RevenueManager;
import br.com.moneyiteasy.service.user.UserManager;

import java.util.Scanner;

public class FintechApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManager();
        BankManager bankManager = new BankManager();
        RevenueManager revenueManager = new RevenueManager();
        ExpenseManager expenseManager = new ExpenseManager();
        int op;

        do {
            System.out.println("\nSejam bem-vindo(a) ao Money It Easy! Escolha uma opção: ");
            System.out.println("1-Cadastrar Usuário: ");
            System.out.println("2-Exibir Usuários: ");
            System.out.println("3-Exibir todas informações dos usuários: ");
            System.out.println("4-Deletar Usuário: ");
            System.out.println("-Cadastrar Receita: ");
            System.out.println("-Exibir Receita: ");
            System.out.println("-Cadastrar Despesa: ");
            System.out.println("-Exibir Despesa: ");
            System.out.println("-Cadastrar conta bancária: ");
            System.out.println("-Exibir conta bancária: ");
            System.out.println("0-Sair");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    userManager.addUser(scanner);
                    break;
                case 2:
                    userManager.displayUsers();
                    break;
                case 3:
                    userManager.displayAllUsersContent();
                    break;
                case 4:
                    userManager.deleteUser(scanner);
                    break;
                case 5:
                    revenueManager.addTransaction(scanner);
                    break;
                case 6:
                    revenueManager.displayTransactions();
                    break;
                case 7:
                    expenseManager.addTransaction(scanner);
                    break;
                case 8:
                    expenseManager.displayTransactions();
                    break;
                case 9:
                    bankManager.addBankAccount(scanner);
                    break;
                case 10:
                    bankManager.displayAllUsersContent();
                    break;
                case 0:
                    System.out.println("Finalizando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (op != 0);

        scanner.close();
    }
}
