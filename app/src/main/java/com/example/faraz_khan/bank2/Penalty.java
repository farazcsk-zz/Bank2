package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 12/4/15.
 */
class Penalty implements Visitors {
    public Penalty() {

    }

    @Override
    public double visit(BaseAccount account) {
        if (account.get_balance() == 0) {
            return account.get_balance();
        } else {

            account.withdraw(account.get_balance() / 36 * 0.5); // 3 year loan 5% interest
            return account.get_balance();
        }
}
}
