package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
class LCRAccount extends BaseAccount {
    //low credit rating account
    public LCRAccount(String owner, int accNum, int _id) {
        super(owner, accNum, "LCR", _id, 200, 0, 0);
    }
}
