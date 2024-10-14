package br.com.moneyiteasy.model.transaction;

import java.time.LocalDateTime;

public class Investment extends Transaction {
    private double value;
    private String description;

    public Investment() {
    }

    public Investment(String category, double value, LocalDateTime timestamp, String method, boolean type, double value1, String description) {
        super(category, value, timestamp, method, type);
        this.value = value1;
        this.description = description;
    }
}