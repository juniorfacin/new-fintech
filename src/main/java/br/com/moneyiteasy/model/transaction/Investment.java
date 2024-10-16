package br.com.moneyiteasy.model.transaction;

import java.time.LocalDateTime;

public class Investment extends Transaction {
    private double value;
    private String description;
    private int idTransaction;
    private double investmentValue;
    private String investmentNote;
    private int investmentCategory;
    private int idUser;



    public Investment(int idTransaction, double investmentValue, String investmentNote,
                      int investmentCategory, int idUser) {
        this.idTransaction = idTransaction;
        this.investmentValue = investmentValue;
        this.investmentNote = investmentNote;
        this.investmentCategory = investmentCategory;
        this.idUser = idUser;
    }

    public Investment(double investmentValue, String investmentNote,
                      int investmentCategory, int idUser) {
        this.investmentValue = investmentValue;
        this.investmentNote = investmentNote;
        this.investmentCategory = investmentCategory;
        this.idUser = idUser;
    }

    public Investment() {
    }

    public Investment(String category, double value, LocalDateTime timestamp, String method, boolean type, double value1, String description) {
        super(category, value, timestamp, method, type);
        this.value = value1;
        this.description = description;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public double getInvestmentValue() {
        return investmentValue;
    }

    public void setInvestmentValue(double investmentValue) {
        this.investmentValue = investmentValue;
    }

    public String getInvestmentNote() {
        return investmentNote;
    }

    public void setInvestmentNote(String investmentNote) {
        this.investmentNote = investmentNote;
    }

    public int getInvestmentCategory() {
        return investmentCategory;
    }

    public void setInvestmentCategory(int investmentCategory) {
        this.investmentCategory = investmentCategory;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}