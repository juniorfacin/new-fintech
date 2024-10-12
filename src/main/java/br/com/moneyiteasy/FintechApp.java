package br.com.moneyiteasy;

import br.com.moneyiteasy.service.transaction.ExpenseManager;
import br.com.moneyiteasy.service.transaction.RevenueManager;
import br.com.moneyiteasy.service.user.UserManager;

import java.util.Scanner;

public class FintechApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManager();
        RevenueManager revenueManager = new RevenueManager();
        ExpenseManager expenseManager = new ExpenseManager();
        int op;

        do {
            System.out.println("\nSejam bem-vindo(a) ao Money It Easy! Escolha uma opção: ");
            System.out.println("1-Cadastrar Usuário: ");
            System.out.println("2-Exibir Usuário: ");
            System.out.println("3-Cadastrar Receita: ");
            System.out.println("4-Exibir Receita: ");
            System.out.println("5-Cadastrar Despesa: ");
            System.out.println("6-Exibir Despesa: ");
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
                    revenueManager.addTransaction(scanner);
                    break;
                case 4:
                    revenueManager.displayTransactions();
                    break;
                case 5:
                    expenseManager.addTransaction(scanner);
                    break;
                case 6:
                    expenseManager.displayTransactions();
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
