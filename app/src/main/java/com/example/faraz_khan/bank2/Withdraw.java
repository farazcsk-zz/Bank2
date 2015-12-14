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

public class Withdraw extends AppCompatActivity {

    int acc_number;
    double amount;


    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
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

    public void withdraw(View view) {
        ctrl = Control.getInstance();

        EditText account_number = (EditText) findViewById(R.id.acc_num_2);
        EditText withdraw = (EditText) findViewById(R.id.withdraw);


        acc_number = Integer.parseInt(account_number.getText().toString());
        amount = Double.parseDouble(withdraw.getText().toString());

        List<String> WithdrawList = new ArrayList<>();
        WithdrawList = ctrl.withdraw(acc_number, amount);

        ListAdapter WithdrawAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, WithdrawList);
        ListView WithdrawListView = (ListView) findViewById(R.id.withdraw_listview);

        WithdrawListView.setAdapter(WithdrawAdapter);


    }



}
