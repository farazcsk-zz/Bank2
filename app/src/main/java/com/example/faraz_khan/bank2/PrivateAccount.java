package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
public class PrivateAccount extends BaseAccount {

    public PrivateAccount(String owner, int acc_num, int _id, String loanReasons) {
        super(owner, acc_num, "Prviate", _id, 1000, 0.4, 3000, loanReasons);
    }

}