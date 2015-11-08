package com.example.faraz_khan.bank2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Press Back To Return To Menu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void createCurrentAccount(View view) {
        Intent CreateCurrentAccount = new Intent(this, com.example.faraz_khan.bank2.CreateCurrentAccount.class);
        startActivity(CreateCurrentAccount);
    }

    public void createSavingsAccount(View view) {
        Intent CreateSavingsAccount = new Intent(this, com.example.faraz_khan.bank2.CreateSavingsAccount.class);
        startActivity(CreateSavingsAccount);
    }

    public void createStudentAccount(View view) {
        Intent CreateStudentAccount = new Intent(this, com.example.faraz_khan.bank2.CreateStudentAccount.class);
        startActivity(CreateStudentAccount);
    }

    public void createBusinessAccount(View view) {
        Intent CreateBusinessAccount = new Intent(this, com.example.faraz_khan.bank2.CreateBusinessAccount.class);
        startActivity(CreateBusinessAccount);
    }

    public void createSMBAccount(View view) {
        Intent CreateSMBAccount = new Intent(this, com.example.faraz_khan.bank2.CreateSMBAccount.class);
        startActivity(CreateSMBAccount);
    }

    public void createIRAAccount(View view) {
        Intent CreateIRAAccount = new Intent(this, com.example.faraz_khan.bank2.CreateIRAAccount.class);
        startActivity(CreateIRAAccount);
    }

    public void createInternationalAccount(View view) {
        Intent CreateInternationalAccount = new Intent(this, com.example.faraz_khan.bank2.CreateInternationalAccount.class);
        startActivity(CreateInternationalAccount);
    }

    public void createPrivateAccount(View view) {
        Intent CreatePrivateAccount = new Intent(this, com.example.faraz_khan.bank2.CreatePrivateAccount.class);
        startActivity(CreatePrivateAccount);
    }

    public void createDisabilityAccount(View view) {
        Intent CreateDisabilityAccount = new Intent(this, com.example.faraz_khan.bank2.CreateDisabilityAccount.class);
        startActivity(CreateDisabilityAccount);
    }

    public void createChildrensAccount(View view) {
        Intent CreateChildrensAccount = new Intent(this, com.example.faraz_khan.bank2.CreateChildrensAccount.class);
        startActivity(CreateChildrensAccount);
    }
}
