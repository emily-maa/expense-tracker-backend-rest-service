package com.example.restservice;

public class Transaction {
    private int id;
    private double amount;
    private String text;


    public Transaction(int id, double amount, String text) {
        this.id = id;
        this.amount = amount;
        this.text = text;
    }

    public Transaction() {

    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getText(){
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setText(String text){
        this.text = text;
    }
}
