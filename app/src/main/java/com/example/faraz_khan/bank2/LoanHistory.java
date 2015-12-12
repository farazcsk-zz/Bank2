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

