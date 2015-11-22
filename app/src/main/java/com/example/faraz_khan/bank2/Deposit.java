package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Deposit extends AppCompatActivity {

    int acc_number;
    double amount;
    Control ctrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Press Back To Return To Main Menu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void depositButton(View view) {
        ctrl = Control.getInstance();

        EditText account_number = (EditText) findViewById(R.id.acc_num);
        EditText deposit_amount = (EditText) findViewById(R.id.deposit);


        acc_number = Integer.parseInt(account_number.getText().toString());
        amount = Double.parseDouble(deposit_amount.getText().toString());

        ctrl.deposit(acc_number, amount);

        TextView output = (TextView) findViewById(R.id.deposit_output);
        output.setText(createSummary(acc_number, amount));


    }

    public String createSummary(int acc_number, double amount) {
        String message = "Your Deopsit of: ";
        message += "\nAmount: " + amount;
        message += "\nTo Account Number: " + acc_number;
        message += "\nHas Been Successful!";


        return message;
    }


}