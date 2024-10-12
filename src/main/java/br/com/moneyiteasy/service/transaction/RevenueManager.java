package br.com.moneyiteasy.service.transaction;

import br.com.moneyiteasy.model.transaction.Revenue;
import br.com.moneyiteasy.model.transaction.Transaction;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RevenueManager extends TransactionManager {

    @Override
    protected String getTransactionType() {
        return "receita";
    }

    @Override
    protected Transaction createTransaction(String category, double value, LocalDateTime timestamp, String method) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a origem da receita: ");
        String origin = scanner.nextLine();

        return new Revenue(category, value, timestamp, method, origin, true);
    }

    @Override
    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Nenhuma receita cadastrada.");
        } else {
            System.out.println("Receitas cadastradas:");
            for (Transaction transaction : transactions) {
                Revenue income = (Revenue) transaction;
                System.out.printf("Categoria: %s | Valor: R$ %.2f | Data e Hora: %s | Método de pagamento: %s | Origem: %s\n",
                        income.getCategory(), income.getValue(), income.getFormattedTimestamp(), income.getMethod(), income.getOrigin());
            }
            System.out.printf("Total de receitas: R$ %.2f\n", getTotalValue());
        }
    }
}
