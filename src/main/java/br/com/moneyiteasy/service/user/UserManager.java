package br.com.moneyiteasy.service.user;

import br.com.moneyiteasy.dao.UserDao;
import br.com.moneyiteasy.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UserManager {
    private UserDao userDao = new UserDao();

    public void addUser(Scanner scanner) {
        System.out.println("Cadastro de Usuário.");
        boolean success = false;

        while (!success) {
            try {
                User user = new User();  // Cria uma nova instância a cada tentativa
                System.out.println("Nome: ");
                user.setName(scanner.nextLine().trim());
                System.out.println("Email: ");
                user.setEmail(scanner.nextLine().trim());
                System.out.println("CPF (apenas números): ");
                user.setCpf(scanner.nextLine().trim());
                System.out.println("Senha: ");
                user.setPassword(scanner.nextLine().trim());

                if (!isUserExists(user)) {
                    userDao.addUser(user);
                    System.out.println("Usuário cadastrado com sucesso!");
                    success = true;
                } else {
                    System.out.println("Usuário com o mesmo email ou CPF já cadastrado. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Erro de banco de dados: " + e.getMessage());
                success = true;  // Para evitar looping infinito em caso de erro de conexão
            }
        }
    }

    public void displayUsers() {
        if (!userDao.getUserNamesAndCpfs().isEmpty()) {
            for (User user : userDao.getUserNamesAndCpfs()) {
                user.displayUser();
            }
        } else {
            System.out.println("Nenhum usuário cadastrado!");
        }
    }

    private boolean isUserExists(User user) {
        return userDao.getUserNamesAndCpfs().stream()
                .anyMatch(u -> u.getName().equals(user.getName()) || u.getCpf().equals(user.getCpf()));
    }
}
