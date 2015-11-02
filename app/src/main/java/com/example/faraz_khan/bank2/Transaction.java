package com.example.faraz_khan.bank2;

import java.util.Date;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class Transaction {
    protected Date time;
    protected double amount;
    String transactionType;

    public Transaction(Date _time, String _transactionType, double _amount) {
        time = _time;
        transactionType = _transactionType;
        amount = _amount;

    }

    public Date getDate() {
        return time;
    }

    public String getType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

}