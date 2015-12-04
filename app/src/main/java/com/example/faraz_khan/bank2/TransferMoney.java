package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TransferMoney extends AppCompatActivity {
    int acc_number;
    int acc_number_2;
    double amount;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void transferButton(View view) {
        ctrl = Control.getInstance();

        EditText account_number_from = (EditText) findViewById(R.id.transfer_from);
        EditText transfer_amount = (EditText) findViewById(R.id.transfer_amount);
        EditText account_number_to = (EditText) findViewById(R.id.transfer_to);


        acc_number = Integer.parseInt(account_number_from.getText().toString());
        acc_number_2 = Integer.parseInt(account_number_to.getText().toString());
        amount = Double.parseDouble(transfer_amount.getText().toString());

        ctrl.transferMoney(acc_number, amount, acc_number_2);

        TextView output = (TextView) findViewById(R.id.transfer_money_output);
        output.setText(createSummary(acc_number, amount, acc_number_2));


    }

    public String createSummary(int acc_number, double amount, int acc_number_2) {
        String message = "Your transfer of: ";
        message += "\nAmount: " + amount;
        message += "\nTo Account Number: " + acc_number;
        message += "\nTo Account Number: " + acc_number_2;
        message += "\nHas Been Successful!";


        return message;
    }

}
