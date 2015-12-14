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

public class CreateInternationalAccount extends AppCompatActivity {

    public double amount;
    public String name;
    Control ctrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_international_account);
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

    public void cInternationalAccount(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_6);
        EditText customer_surname = (EditText) findViewById(R.id.surname_6);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_6);
        int id = Integer.parseInt(idtext.getText().toString());


        List<String> createInternationalAccountList = new ArrayList<>();
        createInternationalAccountList = ctrl.createAccount(11, name, id, "");

        ListAdapter cInternationalAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, createInternationalAccountList);
        ListView createInternationalAccountListView = (ListView) findViewById(R.id.internationalAccount_listview);

        createInternationalAccountListView.setAdapter(cInternationalAdapter);




    }


}
