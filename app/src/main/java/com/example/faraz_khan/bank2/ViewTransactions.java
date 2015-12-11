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

public class ViewTransactions extends AppCompatActivity {
    int acc_number;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);
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

    public void viewTransactionsButton(View view) {
        ctrl = Control.getInstance();

        EditText account_number = (EditText) findViewById(R.id.acc_num_transactions);


        acc_number = Integer.parseInt(account_number.getText().toString());
        List<String> transactionList = new ArrayList<>();
        transactionList = ctrl.showTransactions(acc_number);


        ListAdapter tAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, transactionList);
        ListView transactionListView = (ListView) findViewById(R.id.transaction_listview);

        transactionListView.setAdapter(tAdapter);


    }



}
