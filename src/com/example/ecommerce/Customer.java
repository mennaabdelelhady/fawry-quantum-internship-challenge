package com.example.ecommerce;

public class Customer {
    private String name;
    private int balance;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deductAmount(int amount) {
        balance -= amount;
    }
}
