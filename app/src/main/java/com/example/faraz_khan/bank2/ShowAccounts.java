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

public class ShowAccounts extends AppCompatActivity {
    int id;
    Control ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_accounts);
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

    public void showAccounts(View view) {
        ctrl = Control.getInstance();


        EditText idText = (EditText) findViewById(R.id.showAccounts_id);
        id = Integer.parseInt(idText.getText().toString());


        List<String> ShowAccountsList = new ArrayList<>();
        ShowAccountsList = ctrl.showAccounts(id);

        ListAdapter ShowAccountsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ShowAccountsList);
        ListView ShowAccountsListView = (ListView) findViewById(R.id.showAccounts_listview);

        ShowAccountsListView.setAdapter(ShowAccountsAdapter);
    }

}
