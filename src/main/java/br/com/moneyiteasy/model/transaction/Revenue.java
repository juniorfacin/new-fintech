package br.com.moneyiteasy.model.transaction;

import java.time.LocalDateTime;

public class Revenue extends Transaction {
    private int idTransaction;
    private int revenueCategory;
    private int idRevenueOrigin;
    private double revenueValue;
    private String revenueNote;
    private int idUser;

    public Revenue() {

    }

    public Revenue(int idTransaction, int revenueCategory,int idRevenueOrigin, double revenueValue, String revenueNote,
                   int idUser) {
        this.idTransaction = idTransaction;
        this.revenueCategory = revenueCategory;
        this.idRevenueOrigin = idRevenueOrigin;
        this.revenueValue = revenueValue;
        this.revenueNote = revenueNote;
        this.idUser = idUser;
    }

    public Revenue(int revenueCategory, int idRevenueOrigin, double revenueValue, String revenueNote,
                   int idUser) {
        this.revenueCategory = revenueCategory;
        this.revenueValue = revenueValue;
        this.revenueNote = revenueNote;
        this.idUser = idUser;
    }

    private String origin;
    public Revenue (String category, double value, LocalDateTime timestamp, String method, String origin, boolean type){
        super(category, value, timestamp, method, type);
        this.origin = origin;
        this.setType(true);
    }
    public String getOrigin() {return origin;}
    public void setOrigin(String origin) { this.origin = origin; }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getRevenueCategory() {
        return revenueCategory;
    }

    public void setRevenueCategory(int revenueCategory) {
        this.revenueCategory = revenueCategory;
    }

    public int getIdRevenueOrigin() {
        return idRevenueOrigin;
    }

    public void setIdRevenueOrigin(int idRevenueOrigin) {
        this.idRevenueOrigin = idRevenueOrigin;
    }

    public double getRevenueValue() {
        return revenueValue;
    }

    public void setRevenueValue(double revenueValue) {
        this.revenueValue = revenueValue;
    }

    public String getRevenueNote() {
        return revenueNote;
    }

    public void setRevenueNote(String revenueNote) {
        this.revenueNote = revenueNote;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}