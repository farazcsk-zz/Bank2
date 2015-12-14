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

public class ChangeOverdraft extends AppCompatActivity {
    int accNumber;
    int limit;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_overdraft);
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

    public void changeOverdraftButton(View view) {
        ctrl = Control.getInstance();


        EditText idText = (EditText) findViewById(R.id.changeOverdraft_accNumber);
        accNumber = Integer.parseInt(idText.getText().toString());
        EditText limitText = (EditText) findViewById(R.id.changeOverdraft_newLimit);
        limit = Integer.parseInt(limitText.getText().toString());


        List<String> ChangeOverdraftList = new ArrayList<>();
        ChangeOverdraftList = ctrl.changeOverdraft(accNumber, limit);

        ListAdapter ChangeOverdraftAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ChangeOverdraftList);
        ListView ChangeOverdraftListView = (ListView) findViewById(R.id.changeOverdraft_listview);

        ChangeOverdraftListView.setAdapter(ChangeOverdraftAdapter);
    }

}
