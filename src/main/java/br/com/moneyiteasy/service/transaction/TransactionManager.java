package br.com.moneyiteasy.service.transaction;

import br.com.moneyiteasy.model.DataHorario;
import br.com.moneyiteasy.model.transaction.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TransactionManager {
    protected List<Transaction> transactions = new ArrayList<>();
    protected DataHorario dataHorario = new DataHorario();

    public void addTransaction(Scanner scanner) {
        System.out.println("Digite a categoria da " + getTransactionType() + ": ");
        String category = scanner.nextLine();
        System.out.println("Digite o valor da " + getTransactionType() + ": ");
        double value = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite o método de pagamento: ");
        String method = scanner.nextLine();

        LocalDateTime timestamp = dataHorario.getDateTime();
        Transaction transaction = createTransaction(category, value, timestamp, method);
        transactions.add(transaction);
    }

    public double getTotalValue() {
        double total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getValue();
        }
        return total;
    }

    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Nenhuma " + getTransactionType() + " cadastrada.");
        } else {
            System.out.println(getTransactionType() + "s cadastradas:");
            for (Transaction transaction : transactions) {
                System.out.printf("Categoria: %s | Valor: %s R$ %.2f | Data e Hora: %s | Método de pagamento: %s\n",
                        transaction.getCategory(),transaction.isType(), transaction.getValue(), transaction.getFormattedTimestamp(), transaction.getMethod());
            }
            System.out.printf("Total de " + getTransactionType() + "s: R$ %.2f\n", getTotalValue());
        }
    }

    protected abstract String getTransactionType();

    protected abstract Transaction createTransaction(String category, double value, LocalDateTime timestamp, String method);
}
