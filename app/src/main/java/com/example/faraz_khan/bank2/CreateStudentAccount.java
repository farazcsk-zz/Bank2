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

public class CreateStudentAccount extends AppCompatActivity {

    public double amount;
    public String name;
    // public ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Press Back To Return To Create Account", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void cSTUAccount(View view) {

        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_2);
        EditText customer_surname = (EditText) findViewById(R.id.surname_2);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_2);
        int id = Integer.parseInt(idtext.getText().toString());


        // accounts.add(new StudentAccount(name, acc_num, id));
        List<String> createStudentAccountList = new ArrayList<>();
        createStudentAccountList = ctrl.createAccount(3, name, id, "");

        ListAdapter cStudentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, createStudentAccountList);
        ListView createStudentAccountListView = (ListView) findViewById(R.id.createStudentAccount_listview);

        createStudentAccountListView.setAdapter(cStudentAdapter);


    }


}
