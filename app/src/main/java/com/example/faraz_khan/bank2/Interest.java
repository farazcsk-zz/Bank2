package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 12/4/15.
 */
public class Interest implements Visitors {
    public Interest() {

    }

    public double visit(BaseAccount account) {

        if ("Loan".equals(account.get_acc_type())) {
            return account.get_balance();

        } else
            account.deposit(account.get_balance() * 0.5);

        return account.get_balance();
    }
}

