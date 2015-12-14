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

public class CreateSavingsAccount extends AppCompatActivity {

    public double amount;
    public String name;
    public ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();
    Control ctrl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_savings_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Press Bank To Return To Create Account", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void csAccount(View view) {

        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_1);
        EditText customer_surname = (EditText) findViewById(R.id.surname_1);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_1);
        int id = Integer.parseInt(idtext.getText().toString());


        // accounts.add(new SavingsAccount(name, acc_num, id));
        List<String> createSavingsAccountList = new ArrayList<>();
        createSavingsAccountList = ctrl.createAccount(2, name, id, "");

        ListAdapter cSAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, createSavingsAccountList);
        ListView createSavingsAccountListView = (ListView) findViewById(R.id.createSavingsAccount_listview);

        createSavingsAccountListView.setAdapter(cSAdapter);


    }


}
