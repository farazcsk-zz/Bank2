package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/27/15.
 */
public class Memento {
    private double balance;
    private String state;

    public Memento(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
