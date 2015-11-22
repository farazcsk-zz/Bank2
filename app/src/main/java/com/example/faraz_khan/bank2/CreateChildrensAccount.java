package com.example.faraz_khan.bank2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateChildrensAccount extends AppCompatActivity {
    public int acc_num;
    public int accNumGenerator;
    public double amount;
    public String name;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_childrens_account);
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

    public void cChildrensAccount(View view) {
        ctrl = Control.getInstance();
        EditText customer_first_name = (EditText) findViewById(R.id.first_name_9);
        EditText customer_surname = (EditText) findViewById(R.id.surname_9);

        name = customer_first_name.getText().toString();
        name += " ";
        name += customer_surname.getText().toString();

        EditText idtext = (EditText) findViewById(R.id.ID_9);
        int id = Integer.parseInt(idtext.getText().toString());
        accNumGenerator++;
        acc_num++;

        ctrl.createAccount(9, name, acc_num, id);


        TextView output = (TextView) findViewById(R.id.childrens_account_output);
        output.setText(createSummary(name, acc_num, id));


    }

    public String createSummary(String name, int acc_num, int id) {

        String message = "Your Childrens Account: ";
        message += "\nName: " + name;
        message += "\nAccount Number: " + acc_num;
        message += "\nID: " + id;
        message += "\nHas Successfully Been Created!";


        return message;
    }
}
