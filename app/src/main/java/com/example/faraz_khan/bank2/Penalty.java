package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 12/4/15.
 */
class Penalty implements Visitors {
    public Penalty() {

    }

    @Override
    public double visit(BaseAccount account) {

        account.withdraw(account.get_balance() * 0.5);
        return account.get_balance();
    }
}
