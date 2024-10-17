package br.com.moneyiteasy;

import br.com.moneyiteasy.dao.BankAccountDao;
import br.com.moneyiteasy.dao.CategoryDao;
import br.com.moneyiteasy.dao.UserDao;
import br.com.moneyiteasy.model.BankAccount;
import br.com.moneyiteasy.model.Category;
import br.com.moneyiteasy.model.User;
import br.com.moneyiteasy.service.BankManager;
import br.com.moneyiteasy.service.CategoryManager;
import br.com.moneyiteasy.service.UserManager;

import java.sql.SQLException;

public class TesteDao {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        UserManager userManager = new UserManager();
        User user1 = new User("Joao1", "jp1@gmail.com", "01234567891", "Jp+0123456");
        User user2 = new User("Joao2", "jp2@gmail.com", "01234567892", "Jp+0123456");
        User user3 = new User("Joao3", "jp3@gmail.com", "01234567893", "Jp+0123456");
        User user4 = new User("Joao4", "jp4@gmail.com", "01234567894", "Jp+0123456");
        User user5 = new User("Joao5", "jp5@gmail.com", "01234567895", "Jp+0123456");
        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);
        userDao.addUser(user4);
        userDao.addUser(user5);

        userManager.displayAllUsersContent();


        BankManager bankManager = new BankManager();
        BankAccountDao bankAccountDao = new BankAccountDao();

        BankAccount bankAccount1 = new BankAccount(1,"Bradesco", 1257,"12345","1234","1");
        BankAccount bankAccount2 = new BankAccount(2,"Itau", 1258,"12345","1234","1");
        BankAccount bankAccount3 = new BankAccount(3,"Nubank", 1259,"12345","1234","1");
        BankAccount bankAccount4 = new BankAccount(4,"Santander", 12506,"12345","1234","1");
        BankAccount bankAccount5 = new BankAccount(5,"Caixa", 1251,"12345","1234","1");
        bankAccountDao.addBankAccount(bankAccount1);
        bankAccountDao.addBankAccount(bankAccount2);
        bankAccountDao.addBankAccount(bankAccount3);
        bankAccountDao.addBankAccount(bankAccount4);
        bankAccountDao.addBankAccount(bankAccount5);
        bankManager.displayAllUsersContent();

        CategoryDao categoryDao = new CategoryDao();
        Category category1 = new Category("Restaurante");
        Category category2 = new Category("Casa");
        Category category3 = new Category("Carro");
        Category category4 = new Category("Mercado");
        Category category5 = new Category("Luz");
        categoryDao.addExpenseCategory(category1);
        categoryDao.addExpenseCategory(category2);
        categoryDao.addExpenseCategory(category3);
        categoryDao.addExpenseCategory(category4);
        categoryDao.addExpenseCategory(category5);
        categoryDao.getAllExpenseCategory();

        CategoryManager categoryManager = new CategoryManager();
        categoryManager.displayExpenseCategories();



    }
}