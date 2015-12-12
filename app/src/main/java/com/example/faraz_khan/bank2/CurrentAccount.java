package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class CurrentAccount extends BaseAccount {

    public CurrentAccount(String owner, int acc_num, int _id, String loanReasons) {
        super(owner, acc_num, "Current", _id, 500, 0.01, 1000, loanReasons);
    }

}