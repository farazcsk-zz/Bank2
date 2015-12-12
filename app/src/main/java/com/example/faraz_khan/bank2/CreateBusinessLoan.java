package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateBusinessLoan extends AppCompatActivity {
    public int acc_num;
    public int accNumGenerator;
    public double amount;
    public String name;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_loan);
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

    public void createBusinessLoanButton(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_businessloan);
        EditText customer_surname = (EditText) findViewById(R.id.surname_businessloan);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_businessloan);
        int id = Integer.parseInt(idtext.getText().toString());
        EditText accNumText = (EditText) findViewById(R.id.accnum_businessloan);
        acc_num = Integer.parseInt(accNumText.getText().toString());
        EditText amountText = (EditText) findViewById(R.id.amount_businessloan);
        amount = Double.parseDouble(amountText.getText().toString());


        ctrl.createLoan(name, id, acc_num, 2, "Business Loan");
        //accounts.add(new BusinessAccount(name, acc_num, id));

        TextView output = (TextView) findViewById(R.id.businessloan_output);
        output.setText(createSummary(name, acc_num, amount));


    }

    public String createSummary(String name, int acc_num, double amount) {

        String message = "Your business Loan: ";
        message += "\nName: " + name;
        message += "\nAccount Number: " + acc_num;
        message += "\nAmount: " + amount;
        message += "\nHas Successfully Been Approved!";


        return message;
    }

}
