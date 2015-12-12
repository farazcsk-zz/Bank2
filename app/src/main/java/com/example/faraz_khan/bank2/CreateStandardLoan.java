package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateStandardLoan extends AppCompatActivity {
    public int acc_num;
    public int accNumGenerator;
    public double amount;
    public String name;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_standard_loan);
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


    public void createStandardLoanButton(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_standardloan);
        EditText customer_surname = (EditText) findViewById(R.id.surname_standardloan);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_standardloan);
        int id = Integer.parseInt(idtext.getText().toString());
        EditText accNumText = (EditText) findViewById(R.id.accnum_standardloan);
        acc_num = Integer.parseInt(accNumText.getText().toString());
        EditText amountText = (EditText) findViewById(R.id.amount_standardloan);
        amount = Double.parseDouble(amountText.getText().toString());


        ctrl.createLoan(name, id, acc_num, 1, "Standard Loan");
        //accounts.add(new BusinessAccount(name, acc_num, id));

        TextView output = (TextView) findViewById(R.id.standardloan_output);
        output.setText(createSummary(name, acc_num, amount));


    }

    public String createSummary(String name, int acc_num, double amount) {

        String message = "Your Standard Loan: ";
        message += "\nName: " + name;
        message += "\nAccount Number: " + acc_num;
        message += "\nAmount: " + amount;
        message += "\nHas Successfully Been Approved!";


        return message;
    }

}
