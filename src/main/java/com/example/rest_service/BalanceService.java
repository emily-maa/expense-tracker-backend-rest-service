package com.example.restservice;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BalanceService {
    //Define an arr list to keep the balance values
    private List<Balance> balances=new ArrayList<>();
    
    public BalanceService(){
        balances.add(new Balance(1,0,0,0));
        balances.add(new Balance(2,0,0,0));
    }
    //Create a method getBalance(): return arr list 
    public Balance getBalance(int id){
        for (Balance b: balances){
            if(b.getId()==id) {
                return b;
            }
        }
        System.out.println("no balance available");
        return null;
    }
}
