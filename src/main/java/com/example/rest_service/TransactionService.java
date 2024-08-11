package com.example.restservice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class TransactionService {
    HashMap<Integer, ArrayList<Transaction>> transactions = new HashMap<Integer, ArrayList<Transaction>>();

    public TransactionService(){
        transactions.put(1,new ArrayList<Transaction>());
        transactions.put(2,new ArrayList<Transaction>());
        transactions.put(3,new ArrayList<Transaction>());
    }
    public ArrayList<Transaction> getTransactions(int id){
        // System.out.println(this.transactions);
        return this.transactions.get(id);
    }
    public void addTransaction(Transaction newTransaction, Balance balance){
        this.getTransactions(balance.getId()).add(newTransaction);

        //adjust balance, income, and expense
        balance.setCurrentBalance(balance.getCurrentBalance()+newTransaction.getAmount());
        if (newTransaction.getAmount()>0) {
            balance.setIncome(balance.getIncome()+newTransaction.getAmount());
        }
        else {
            balance.setExpense(balance.getExpense()+Math.abs(newTransaction.getAmount())); 
        }
    }

    public void deleteTransaction(int transactionId, Balance balance){
        Iterator<Transaction> itr = this.getTransactions(balance.getId()).iterator();  
        while (itr.hasNext())   
        {   
            Transaction t  = itr.next();   
            if (t.getId()==transactionId){
                itr.remove();
                balance.setCurrentBalance(balance.getCurrentBalance()-t.getAmount());
                if (t.getAmount()>0) {
                    balance.setIncome(balance.getIncome()-t.getAmount());
                }
                else {
                    balance.setExpense(balance.getExpense()-Math.abs(t.getAmount())); 
                }
            }      
        } 
    }
}
