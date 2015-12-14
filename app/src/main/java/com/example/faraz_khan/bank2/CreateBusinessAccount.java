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

public class CreateBusinessAccount extends AppCompatActivity {

    public double amount;
    public String name;
    //public ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_account);
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


    public void cBAccount(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_3);
        EditText customer_surname = (EditText) findViewById(R.id.surname_3);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_3);
        int id = Integer.parseInt(idtext.getText().toString());


        //accounts.add(new BusinessAccount(name, acc_num, id));

        List<String> createBusinessAccountList = new ArrayList<>();
        createBusinessAccountList = ctrl.createAccount(4, name, id, "");

        ListAdapter cBusinessAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, createBusinessAccountList);
        ListView createBusinessAccountListView = (ListView) findViewById(R.id.createBusinessAccount_listview);

        createBusinessAccountListView.setAdapter(cBusinessAdapter);


    }


}
