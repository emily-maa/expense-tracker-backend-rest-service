package com.example.restservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    List<User> users= new ArrayList<>(Arrays.asList(new User(1,"abc","abc123"),new User(2,"xyz","zyx123")));

    public boolean login(int id, String pwd) {
        for (User a: users){

            if(a.getId()==id && a.getPassword().equalsIgnoreCase(pwd)) {
                System.out.println(" Success");
                return true;
            }
        }
        System.out.println(" Fail");
        return false;
    }
    public User getUser(int id) {
        for (User a: users){

            if(a.getId()==id) {
                return a;
            }
        }
        return null;
    }
}
