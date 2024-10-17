package br.com.moneyiteasy.service.transaction;

import br.com.moneyiteasy.dao.InvestmentDao;
import br.com.moneyiteasy.model.transaction.Investment;
import br.com.moneyiteasy.model.transaction.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class InvestmentManager extends TransactionManager {
    InvestmentDao investmentDao = new InvestmentDao();
    @Override
    protected String getTransactionType() {
        return "investimento";
    }

    @Override
    protected Transaction createTransaction(String category, double value, LocalDateTime timestamp, String method) {
        return new Investment(category, value, timestamp, method, false);
    }

    public void displayTransactions() {
        List<Investment> investments = investmentDao.getAllInvestments(); // Usando o DAO para buscar despesas
        if (investments.isEmpty()) {
            System.out.println("Nenhum investimento cadastrado");
        } else {
            System.out.println("Investimentos cadastrados");
            for (Investment investment : investments) {
                System.out.printf("Categoria: %s | Valor: R$ %.2f | Data e Hora: %s | Método de pagamento: %s\n",
                        investment.getCategory(), investment.getValue(), investment.getFormattedTimestamp(), investment.getMethod());
            }
            System.out.printf("Total de investimentos: R$ %.2f\n", getTotalValue());
        }
    }


}