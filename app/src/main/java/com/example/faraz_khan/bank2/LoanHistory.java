package com.example.faraz_khan.bank2;

import java.util.Date;

/**
 * Created by faraz-khan on 11/6/15.
 */
class LoanHistory {
    protected Date time;
    protected double loanAmount;
    String loanPaymentType;

    public LoanHistory(Date _time, String _loanPaymentType, double _amount) {
        time = _time;
        loanPaymentType = _loanPaymentType;
        loanAmount = _amount;
    }

    public Date getLoanDate() {
        return time;
    }

    public String getLoanType() {
        return loanPaymentType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}

class Loan extends BaseAccount {
    //loan acts as an account
    public Loan(String owner, int accNum, int _id) {
        super(owner, accNum, "Loan", _id, 0, 0, 0);
    }
}