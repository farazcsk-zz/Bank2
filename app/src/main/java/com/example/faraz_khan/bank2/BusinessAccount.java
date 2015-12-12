package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class BusinessAccount extends BaseAccount {

    public BusinessAccount(String business_name, int acc_num, int _id, String loanReasons) {
        super(business_name, acc_num, "Business", _id, 2000, 0.02, 5000, loanReasons);
    }


}