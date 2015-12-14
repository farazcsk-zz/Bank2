package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CreateStandardLoan extends AppCompatActivity {
    public int acc_num;
    public String name;
    int loan;
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
        loan = Integer.parseInt(amountText.getText().toString());


        List<String> CreateStandardLoanList = new ArrayList<>();
        CreateStandardLoanList = ctrl.createLoan(name, id, acc_num, 1, "Standard Loan", loan);

        ListAdapter CreateStandardLoanAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CreateStandardLoanList);
        ListView CreateStandardLoanListView = (ListView) findViewById(R.id.standardLoan_listview);

        CreateStandardLoanListView.setAdapter(CreateStandardLoanAdapter);


    }



}
