package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */
public interface Account {
    void deposit(double amount);

    double get_balance();

    double accept(Visitors visitor);

}
