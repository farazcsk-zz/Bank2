package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class SMBAccount extends BaseAccount {

    public SMBAccount(String owner, int acc_num, int _id, String loanReasons) {

        super(owner, acc_num, "Current", _id, 500, 0.02, 500, loanReasons);
    }

}