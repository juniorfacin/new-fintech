package br.com.moneyiteasy.model.transaction;

import java.time.LocalDateTime;

public class Expense extends Transaction {
    public Expense (String category, double value, LocalDateTime timestamp, String method, boolean type){
        super(category, value, timestamp,method, type);
        this.setType(false);
    }
}