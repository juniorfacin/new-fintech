package br.com.moneyiteasy.service;

import br.com.moneyiteasy.dao.CategoryDao;
import br.com.moneyiteasy.model.Category;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CategoryManager {
    private final CategoryDao categoryDao;

    public CategoryManager() {
        this.categoryDao = new CategoryDao();
    }

    public void addExpenseCategory(Scanner scanner) {
        System.out.print("Digite o nome da nova categoria de despesa: ");
        String categoryName = scanner.nextLine();
        Category category = new Category(categoryName);

        try {
            boolean success = categoryDao.addExpenseCategory(category);
            if (success) {
                System.out.println("Categoria de despesa adicionada com sucesso!");
            } else {
                System.out.println("Erro ao adicionar a categoria de despesa.");
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void displayExpenseCategories() {
        List<Category> categories = categoryDao.getAllExpenseCategory();
        if (categories.isEmpty()) {
            System.out.println("Nenhuma categoria de despesa cadastrada.");
        } else {
            System.out.println("Categorias de Despesa:");
            for (Category category : categories) {
                System.out.println("ID: " + category.getId() + " - Nome: " + category.getCategoryName());
            }
        }
    }

    public void deleteExpenseCategory(Scanner scanner) {
        System.out.print("Digite o nome da categoria de despesa a ser deletada: ");
        String categoryName = scanner.nextLine();

        try {
            boolean success = categoryDao.deleteExpenseCategory(categoryName);
            if (success) {
                System.out.println("Categoria de despesa deletada com sucesso!");
            } else {
                System.out.println("Erro ao deletar a categoria de despesa.");
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void addInvestmentCategory(Scanner scanner) {
        System.out.print("Digite o nome da nova categoria de investimento: ");
        String categoryName = scanner.nextLine();
        Category category = new Category(categoryName);

        try {
            boolean success = categoryDao.addInvestmentCategory(category);
            if (success) {
                System.out.println("Categoria de investimento adicionada com sucesso!");
            } else {
                System.out.println("Erro ao adicionar a categoria de investimento.");
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void displayInvestmentCategories() {
        List<Category> categories = categoryDao.getAllInvestmentCategory();
        if (categories.isEmpty()) {
            System.out.println("Nenhuma categoria de investimento cadastrada.");
        } else {
            System.out.println("Categorias de Investimento:");
            for (Category category : categories) {
                System.out.println("ID: " + category.getId() + " - Nome: " + category.getCategoryName());
            }
        }
    }

    public void deleteInvestmentCategory(Scanner scanner) {
        System.out.print("Digite o nome da categoria de investimento a ser deletada: ");
        String categoryName = scanner.nextLine();

        try {
            boolean success = categoryDao.deleteInvestmentCategory(categoryName);
            if (success) {
                System.out.println("Categoria de investimento deletada com sucesso!");
            } else {
                System.out.println("Erro ao deletar a categoria de investimento.");
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}