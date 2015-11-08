package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
class IslamicAccount extends BaseAccount {
    public IslamicAccount(String owner, int accNum, int _id) {
        super(owner, accNum, "Islamic", _id, 500, 0, 0);
    }
}