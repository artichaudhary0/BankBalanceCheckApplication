package com.example.bankbalancecheckapp;

import java.io.Serializable;
import java.util.ArrayList;

public class UserData implements Serializable {
    private  String name;
    private String accountNumber;
    private double balance ;
    private ArrayList<String> transactions ;


    public UserData(String name,String accountNumber , double balance)
    {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }


    public String getName()
    {
        return name;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public  ArrayList<String> getTransaction()
    {
        return transactions;
    }

    public void setBalance(double balance)
    {
        this.balance = balance ;
    }

    public void addTransaction(String transaction)
    {
        transactions.add(transaction);
    }






}
