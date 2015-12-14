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

public class AddAccountHolder extends AppCompatActivity {
    int acc_number;
    String name;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account_holder);
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

    public void aAccountHolder(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.add_account_holder_name);


        name = customer_first_name.getText().toString();


        EditText accText = (EditText) findViewById(R.id.add_account_holder_accountNumber);
        acc_number = Integer.parseInt(accText.getText().toString());


        //accounts.add(new BusinessAccount(name, acc_num, id));

        List<String> AddAccountHolderList = new ArrayList<>();
        AddAccountHolderList = ctrl.addAccountHolder(acc_number, name);

        ListAdapter aAccountHolderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AddAccountHolderList);
        ListView AddAccountHolderAccountListView = (ListView) findViewById(R.id.addAccountHolder_listview);

        AddAccountHolderAccountListView.setAdapter(aAccountHolderAdapter);


    }

}
