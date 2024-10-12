package br.com.moneyiteasy.model;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private String cpf;
    private String password;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String email, String cpf, String password) {
        this();
        setName(name);
        setEmail(email);
        setCpf(cpf);
        setPassword(password);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        this.email = email;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("^\\d{11}$")) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8 || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).{8,}$")) {
            throw new IllegalArgumentException("Senha inválida!");
        }
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getPassword() { return password; }

    public void displayUser() {
        System.out.printf("Nome: %s | E-mail: %s | CPF: %s%n", name, email, cpf);
    }
}