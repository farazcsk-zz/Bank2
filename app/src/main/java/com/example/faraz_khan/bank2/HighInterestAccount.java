package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
class HighInterestAccount extends BaseAccount {
    public HighInterestAccount(String owner, int accNum, int _id) {
        super(owner, accNum, "High Interest", _id, 1000, 0.08, 500);
    }
}
