package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class StudentAccount extends BaseAccount {

    public StudentAccount(String owner, int acc_num, int _id, String loanReasons) {
        super(owner, acc_num, "Current", _id, 300, 0.01, 2000, loanReasons);
    }

}