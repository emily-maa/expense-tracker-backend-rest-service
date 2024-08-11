package com.example.restservice;

public class Balance {
    private int id;
    private double currentBalance;
    private double income;
    private double expense;

    public Balance(int id, double currentBalance, double income, double expense) {
        this.id = id;
        this.currentBalance = currentBalance;
        this.income = income;
        this.expense = expense;
    }

    public Balance() {

    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public int getId(){
        return id;
    }
    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

}
