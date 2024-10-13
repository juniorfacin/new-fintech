package br.com.moneyiteasy.model.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Transaction {
    private String category;
    private LocalDateTime timestamp;
    private String method;
    private double value;
    private boolean type;
    private String description;

    public Transaction() {}

    public Transaction(String category, double value, LocalDateTime timestamp, String method, boolean type) {
        this.category = category;
        setValue(value);
        this.timestamp = timestamp;
        this.method = method;
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo!");
        }
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return timestamp.format(formatter);
    }

    public String isType() {
        return type ? "" : "-";
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public static class Investment extends Transaction {
        private int id;
        private double amount;
        private String description;

    }
}