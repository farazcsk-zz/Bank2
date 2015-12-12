package com.example.faraz_khan.bank2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by faraz-khan on 11/2/15.
 */
public class BaseAccount implements Account {

    public double balance;
    public String account_type;
    public String loan_reasons;
    public int overdraft;
    public int loanAmount;
    protected double interestRate;
    protected int acc_number;
    protected int overdraftLimit;
    protected int accNumber;
    protected int withdrawLimit;
    ArrayList<String> holders = new ArrayList<String>();
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<LoanHistory> loanHistory = new ArrayList<>();
    int id;


    //Set up a new account
    public BaseAccount(String acc_owner, int acc_num, String acc_type, int _id, int wdLimit, double
            intRate, int odLimit, String loanReasons) {
        holders.add(acc_owner);
        acc_number = acc_num;
        account_type = acc_type;
        id = _id;
        withdrawLimit = wdLimit; //id, withdraw limit, interest rate and overdraft limit added to thebase account
        interestRate = intRate;
        overdraftLimit = odLimit;
        loan_reasons = loanReasons;

    }

    public double accept(Visitors visitor) {
        return visitor.visit(this);
    }

    public double getBalance() {
        return balance;
    }

    public Memento saveMemento() {
        return new Memento(this.balance);
    }

    public void getStateFromMemento(Memento Memento) {
        this.balance = Memento.getBalance();
    }
    //Add account holder
    public void AddAccHolder(String acc_owner, int acc_num) {
        holders.add(acc_owner);
        acc_number = acc_num;
    }

    public ArrayList<String> getHolderName() { //changed to arraylist to show all account holders
        return holders; //returns all holder names not just the first one
    }

    public int getID() {
        return id;
    }

    public int getAccountNum() {
        return acc_number;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double get_balance() {
        return balance;
    }

    public String get_acc_type() {
        return account_type;
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    public void changeOverdraft(int limit) {
        overdraft = limit;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loan) {
        loanAmount = loan;
    }

    public double payInterest() {
        double charge;
        if (balance >= 0) {
            charge = interestRate * balance; //if balance is positive, add interest
        } else {
            charge = 0.05 * balance; //if account is in overdraft, interest charged at 5%
        }
        balance += charge;
        return charge;
    }

    public double getInterestRate() {
        return interestRate;
    }


    public void interest_rate() {
        balance += interestRate * balance;
    }

    public void addTransaction(Date d, String trans_Type, double amount) {
        transactions.add(new Transaction(d, trans_Type, amount));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addLoanTransaction(Date d, String loanPaymentType, double amount, String loanReason) {
        loanHistory.add(new LoanHistory(d, loanPaymentType, amount));
    }

    public ArrayList<LoanHistory> getLoanPayments() {
        return loanHistory;
    }

}

