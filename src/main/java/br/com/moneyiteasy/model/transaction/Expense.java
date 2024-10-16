package br.com.moneyiteasy.model.transaction;

import java.time.LocalDateTime;

public class Expense extends Transaction {
    private int idTransaction;
    private int expenseCategory;
    private double expenseValue;
    private String expenseNote;
    private int idUser;

    public Expense() {

    }

    public Expense(int idTransaction, int expenseCategory, double expenseValue, String expenseNote,
                   int idUser) {
        this.idTransaction = idTransaction;
        this.expenseCategory = expenseCategory;
        this.expenseValue = expenseValue;
        this.expenseNote = expenseNote;
        this.idUser = idUser;
    }

    public Expense(int expenseCategory, double expenseValue, String expenseNote,
                   int idUser) {
        this.expenseCategory = expenseCategory;
        this.expenseValue = expenseValue;
        this.expenseNote = expenseNote;
        this.idUser = idUser;
    }

    public Expense (String category, double value, LocalDateTime timestamp, String method, boolean type){
        super(category, value, timestamp,method, type);
        this.setType(false);
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(int expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public double getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(double expenseValue) {
        this.expenseValue = expenseValue;
    }

    public String getExpenseNote() {
        return expenseNote;
    }

    public void setExpenseNote(String expenseNote) {
        this.expenseNote = expenseNote;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}