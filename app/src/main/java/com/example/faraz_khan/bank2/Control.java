package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Control {

    private static Scanner input = new Scanner(System.in);
    private static Control instance;
    private final Timer timer = new Timer();
    int acc_num;
    int acc_number;
    int accNumGenerator;
    double amount;
    String name;
    private ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();

    public Control() {
        accounts.add(new FeesInterestAccount("Fees and Interest", accNumGenerator, 0));//initialiseaccount for interest and penalties
        /***4. Interest payments***/
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < accounts.size(); i++) {
                    double charge = accounts.get(i).payInterest();
                    accounts.get(0).withdraw(charge);
                    accounts.get(i).addTransaction(new Date(), "Interest", (charge));
                }
                System.out.println("Interest has been paid.");
            }
        }, 30000, 30000);


//singleton
    }

    public static Control getInstance() {
        if (instance == null) {

            synchronized (Control.class) {

                if (instance == null) {
                    instance = new Control();
                }
            }
        }
        return instance;
    }


    public void createAccount(int option2, String name, int acc_number, int id) {


                switch (option2) {
                    case 1:
                        accounts.add(new CurrentAccount(name, acc_num, id));
                        break;
                    case 2:
                        accounts.add(new SavingsAccount(name, acc_num, id));
                        break;
                    case 3:
                        accounts.add(new StudentAccount(name, acc_num, id));
                        break;
                    case 4:
                        accounts.add(new BusinessAccount(name, acc_num, id));
                        break;
                    case 5:
                        accounts.add(new SMBAccount(name, acc_num, id));
                        break;
                    case 6:
                        accounts.add(new IRAccount(name, acc_num, id));
                        break;
                    case 7:
                        accounts.add(new HighInterestAccount(name, accNumGenerator, id));
                        break;
                    case 8:
                        accounts.add(new IslamicAccount(name, accNumGenerator, id));
                        break;
                    case 9:
                        accounts.add(new PrivateAccount(name, accNumGenerator, id));
                        break;
                    case 10:
                        accounts.add(new LCRAccount(name, accNumGenerator, id));
                        break;
                }


    }


    public void deposit(int acc_number, double amount) {
                //Write the instruction to the user
                System.out.println("Enter account Number: ");
//Convert the string the user enters to an int
        //  acc_num = Integer.parseInt(input.nextLine());
                //Write instruction to the user
                System.out.println("Enter deposit amount: ");
//Convert the string entered by the user to a double
        // amount = Double.parseDouble(input.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {
                        accounts.get(i).deposit(amount);
                        accounts.get(i).addTransaction(new Date(), "Deposit", amount);

                    }
                }
    }


    public void displayBalance(int acc_number) {
                //Write the instruction to the user
                System.out.println("Enter account Number: ");
//Convert the string the user enters to an int
                acc_number = Integer.parseInt(input.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {
                        System.out.println((accounts.get(i).get_balance()));
                        accounts.get(i).addTransaction(new Date(), "View Balance", amount);

                    }
                }


    }


    public void withdraw(int acc_number, double amount) {
                //Write the instruction to the user
                System.out.println("Enter account Number: ");
//Convert the string the user enters to an int
                acc_number = Integer.parseInt(input.nextLine());
                //Write instruction to the user
                System.out.println("Enter deposit amount: ");
//Convert the string entered by the user to a double
                amount = Double.parseDouble(input.nextLine());

                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {
                        if (accounts.get(i).get_acc_type() == "Current") {
                            if (amount <= 500) {
                                accounts.get(i).withdraw(amount);
                                accounts.get(i).addTransaction(new Date(), "Withdraw", amount);

                            } else {
                                System.out.println("The maximum daily withdrawal for a Current account is ?500. This transaction has been cancelled");

                            }
                        } else if (accounts.get(i).get_acc_type() == "Savings") {
                            if (amount <= 300) {
                                accounts.get(i).withdraw(amount);
                                accounts.get(i).addTransaction(new Date(), "Withdraw", amount);

                            } else {
                                System.out.println("The maximum daily withdrawal for a Savings account is ?300. This transaction has been cancelled");

                            }
                        } else if (accounts.get(i).get_acc_type() == "Business") {
                            if (amount <= 500) {
                                accounts.get(i).withdraw(amount);
                                accounts.get(i).addTransaction(new Date(), "Withdraw", amount);

                            } else {
                                System.out.println("The maximum daily withdrawal for a Business account is ?500. This transaction has been cancelled");

                            }
                        }


                    }
                }
    }


    public void transferMoney(int acc_number, double amount, int acc_number2) {              //Write the instruction to the user
                System.out.println("Enter account Number to transfer money FROM:");
                //Convert the string the user enters to an int
                acc_number = Integer.parseInt(input.nextLine());
                //Write instruction to the user
                System.out.println("Enter transfer amount: ");
//Convert the string entered by the user to a double
                amount = Double.parseDouble(input.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {

                        if (accounts.get(i).get_balance() >= amount) {
                            accounts.get(i).withdraw(amount);
                            accounts.get(i).addTransaction(new Date(), "Transfer", amount);

                        } else {
                            System.out.println("There are insufficient funds to make this transfer");

                        }
                    }
                }

                System.out.println("Enter account Number to transfer money TO: ");
                //Convert the string the user enters to an int
        acc_number2 = Integer.parseInt(input.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {
                        accounts.get(i).deposit(amount);
                        accounts.get(i).addTransaction(new Date(), "Transfer", amount);

                    }
                }

                System.out.println("Payment has been successfully transferred");


    }


    public void payInterest() {

                for (int i = 0; i < accounts.size(); i++) {
                    accounts.get(i).interest_rate();
                }
                System.out.println("Interest has been paid");

    }


    public void addAccountHolder(int acc_number, String name) {
                System.out.println("Enter Account Number");
        acc_number = Integer.parseInt(input.nextLine());
                System.out.println("Enter Customer first and Last Name");
                name = input.nextLine();
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {
                        accounts.get(i).AddAccHolder(name, acc_num);
                        break;
                    }
                }


    }


    public void showAccounts(int acc_number) {
                System.out.println("Enter Account Number");
                int _id = Integer.parseInt(input.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getID() == acc_number) {
                        System.out.println(accounts.get(i).get_acc_type() + " " + accounts.get(i).getHolderName() + " " + accounts.get(i).get_balance());

                    }
                }


    }


    public void showTransactions(int acc_number) {
                System.out.println("Enter Account Number");
                acc_num = Integer.parseInt(input.nextLine());
                int j = 0;
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == acc_number) {
                        while (j < accounts.get(i).getTransactions().size()) {
                            System.out.println(accounts.get(i).getTransactions().get(j).getType() + " " + accounts.get(i).getTransactions().get(j).getDate() + " " + accounts.get(i).getTransactions().get(j).getAmount());
                            j++;
                        }

                    }
                }


    }



}

