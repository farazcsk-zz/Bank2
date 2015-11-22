package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayBalance extends AppCompatActivity {
    int acc_number;
    double balance;
    Control ctrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_balance);
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

    public void displayBalanceButton(View view) {
        ctrl = Control.getInstance();

        EditText account_number = (EditText) findViewById(R.id.acc_num_1);


        acc_number = Integer.parseInt(account_number.getText().toString());
        balance = ctrl.displayBalance(acc_number);


        TextView output = (TextView) findViewById(R.id.display_balance_output);
        output.setText(createSummary(acc_number, balance));


    }

    public String createSummary(int acc_number, double balance) {
        String message = "Your Current Balance is: ";
        message += "\nAmount: " + balance;
        message += "\nAccount Number: " + acc_number;


        return message;
    }

}
