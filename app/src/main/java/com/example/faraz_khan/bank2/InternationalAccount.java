package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
public class InternationalAccount extends BaseAccount {

    public InternationalAccount(String owner, int acc_num, int _id) {
        super(owner, acc_num, "International", _id, 0, 0, 0);
    }

}