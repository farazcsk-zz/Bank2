package com.example.faraz_khan.bank2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class BaseAccount implements Account {

    public double balance;
    public String account_type;
    protected double interestRate;
    protected int acc_number;
    ArrayList<String> holders = new ArrayList<String>();
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    int id;

    //Set up a new account
    public BaseAccount(String acc_owner, int acc_num, String acc_type, int _id) {
        holders.add(acc_owner);
        acc_number = acc_num;
        account_type = acc_type;
    }

    //Add account holder
    public void AddAccHolder(String acc_owner, int acc_num) {
        holders.add(acc_owner);
        acc_number = acc_num;
    }

    public String getHolderName() {
        return holders.get(0);
    }

    public int getID() {
        return id;
    }

    public int getAccountNum() {
        return acc_number;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double get_balance() {
        return balance;
    }

    public String get_acc_type() {
        return account_type;
    }


    public void interest_rate() {
        balance += interestRate * balance;
    }

    public void addTransaction(Date d, String trans_Type, double amount) {
        transactions.add(new Transaction(d, trans_Type, amount));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}