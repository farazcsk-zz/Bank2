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

public class CreateDisabilityAccount extends AppCompatActivity {

    public double amount;
    public String name;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_disability_account);
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

    public void cDisibilityAccount(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_8);
        EditText customer_surname = (EditText) findViewById(R.id.surname_8);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_8);
        int id = Integer.parseInt(idtext.getText().toString());


        List<String> createDisabilityAccountList = new ArrayList<>();
        createDisabilityAccountList = ctrl.createAccount(12, name, id, "");

        ListAdapter cDisabilityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, createDisabilityAccountList);
        ListView createDisabilityAccountListView = (ListView) findViewById(R.id.disabilityAccount_listview);

        createDisabilityAccountListView.setAdapter(cDisabilityAdapter);


    }


}
