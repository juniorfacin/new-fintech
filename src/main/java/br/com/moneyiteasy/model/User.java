package br.com.moneyiteasy.model;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private int id;
    private String name;
    private String email;
    private String cpf;
    private String password;
    private LocalDate date;
    private double balance;

    public User() {
    }

    public User(int id, String name, String email, String cpf, String password, LocalDate date, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.date = LocalDate.now();
        this.balance = balance;
    }

    public User(String name, String email, String cpf, String password, LocalDate date, double balance) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.date = LocalDate.now();
        this.balance = balance;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        this.email = email;
    }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("^\\d{11}$")) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        if (password == null || password.length() < 8 || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).{8,}$")) {
            throw new IllegalArgumentException("Senha inválida!");
        }
        this.password = password;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayUser() {
        System.out.printf("Nome: %s | E-mail: %s | CPF: %s%n", name, email, cpf);
    }
}