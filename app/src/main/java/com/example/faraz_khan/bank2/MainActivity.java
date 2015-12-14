package com.example.faraz_khan.bank2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome To The Bank of Faraz", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.create_account) {
            // Handle the camera action
            Intent CreateAccount = new Intent(this, com.example.faraz_khan.bank2.CreateAccount.class);
            startActivity(CreateAccount);
        } else if (id == R.id.deposit) {
            Intent Deposit = new Intent(this, com.example.faraz_khan.bank2.Deposit.class);
            startActivity(Deposit);

        } else if (id == R.id.display_balance) {
            Intent DisplayBalance = new Intent(this, com.example.faraz_khan.bank2.DisplayBalance.class);
            startActivity(DisplayBalance);

        } else if (id == R.id.withdraw) {
            Intent Withdraw = new Intent(this, com.example.faraz_khan.bank2.Withdraw.class);
            startActivity(Withdraw);

        } else if (id == R.id.transfer_money) {
            Intent TransferMoney = new Intent(this, com.example.faraz_khan.bank2.TransferMoney.class);
            startActivity(TransferMoney);

        } else if (id == R.id.pay_interest) {
            Intent PayInterest = new Intent(this, com.example.faraz_khan.bank2.PayInterest.class);
            startActivity(PayInterest);

        } else if (id == R.id.add_account_holder) {
            Intent AddAccountHolder = new Intent(this, com.example.faraz_khan.bank2.AddAccountHolder.class);
            startActivity(AddAccountHolder);

        } else if (id == R.id.show_accounts) {
            Intent ShowAccounts = new Intent(this, com.example.faraz_khan.bank2.ShowAccounts.class);
            startActivity(ShowAccounts);

        } else if (id == R.id.view_transactions) {
            Intent ViewTransactions = new Intent(this, com.example.faraz_khan.bank2.ViewTransactions.class);
            startActivity(ViewTransactions);

        } else if (id == R.id.change_overdraft) {
            Intent ChangeOverdraft = new Intent(this, com.example.faraz_khan.bank2.ChangeOverdraft.class);
            startActivity(ChangeOverdraft);

        } else if (id == R.id.create_loan) {
            Intent CreateLoan = new Intent(this, com.example.faraz_khan.bank2.CreateLoan.class);
            startActivity(CreateLoan);

        } else if (id == R.id.view_loan_history) {
            Intent ViewLoan = new Intent(this, ViewLoan.class);
            startActivity(ViewLoan);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
