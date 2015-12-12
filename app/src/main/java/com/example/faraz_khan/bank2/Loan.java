package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 12/12/15.
 */
class Loan extends BaseAccount {
    //loan acts as an account
    public Loan(String owner, int accNum, int _id, String loanReasons) {
        super(owner, accNum, "Loan", _id, 0, 0, 0, loanReasons);
    }
}