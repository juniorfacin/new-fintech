package br.com.moneyiteasy.service.user;
import br.com.moneyiteasy.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(Scanner scanner) {
        System.out.println("Cadastro de Usuário.");
        User user = new User();

        boolean success = false;
        while (!success) {
            try {
                System.out.println("Nome: ");
                user.setName(scanner.nextLine());
                System.out.println("Email: ");
                user.setEmail(scanner.nextLine());
                System.out.println("CPF (apenas números): ");
                user.setCpf(scanner.nextLine());
                System.out.println("Senha: ");
                user.setPassword(scanner.nextLine());

                if (!isUserExists(user)) {
                    users.add(user);
                    System.out.println("Usuário cadastrado com sucesso!");
                    success = true;
                } else {
                    System.out.println("Usuário com o mesmo email ou CPF já cadastrado. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            }
        }
    }

    public void displayUsers() {
        if (!users.isEmpty()) {
            for (User user : users) {
                user.displayUser();
            }
        } else {
            System.out.println("Nenhum usuário cadastrado!");
        }
    }

    private boolean isUserExists(User user) {
        return users.stream()
                .anyMatch(u -> u.getEmail().equals(user.getEmail()) || u.getCpf().equals(user.getCpf()));
    }
}