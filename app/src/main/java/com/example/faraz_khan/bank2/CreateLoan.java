package com.example.faraz_khan.bank2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CreateLoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_loan);
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

    public void createStandardLoan(View view) {
        Intent CreateStandardLoan = new Intent(this, com.example.faraz_khan.bank2.CreateStandardLoan.class);
        startActivity(CreateStandardLoan);
    }

    public void createBusinessLoan(View view) {
        Intent CreateBusinessLoan = new Intent(this, com.example.faraz_khan.bank2.CreateBusinessLoan.class);
        startActivity(CreateBusinessLoan);
    }

    public void createStudentLoan(View view) {
        Intent CreateStudentAccount = new Intent(this, com.example.faraz_khan.bank2.CreateStudentAccount.class);
        startActivity(CreateStudentAccount);
    }

    public void createPersonalLoan(View view) {
        Intent CreatePersonalLoan = new Intent(this, com.example.faraz_khan.bank2.CreatePersonalLoan.class);
        startActivity(CreatePersonalLoan);
    }
}
