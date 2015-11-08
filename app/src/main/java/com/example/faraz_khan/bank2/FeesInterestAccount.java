package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
class FeesInterestAccount extends BaseAccount {
    /***
     * 1. central account for paying interest and receiving penalties
     ***/
    public FeesInterestAccount(String owner, int accNum, int _id) {
        super(owner, accNum, "FeesInterest", _id, 0, 0, 0);
    }
}
