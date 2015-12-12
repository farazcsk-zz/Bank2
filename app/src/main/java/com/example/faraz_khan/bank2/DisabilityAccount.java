package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/6/15.
 */
public class DisabilityAccount extends BaseAccount {

    public DisabilityAccount(String owner, int acc_num, int _id, String loanReasons) {
        super(owner, acc_num, "Disability", _id, 0, 0, 0, loanReasons);
    }

}