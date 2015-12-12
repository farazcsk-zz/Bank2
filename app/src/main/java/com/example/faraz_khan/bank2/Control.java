package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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


    ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();

    public Control() {
        final Interest interest = new Interest();


        /***4. Interest payments***/
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < accounts.size(); i++) {
                    double charge = accounts.get(i).accept(interest);
                    //interest visit

                    accounts.get(i).addTransaction(new Date(), "Interest", (charge));
                }
                //System.out.println("Interest has been paid.");
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


    public void createAccount(int option2, String name, int acc_num, int id, String loanReasons) {

        accNumGenerator++;
        switch (option2) {
            case 1:
                accounts.add(new CurrentAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 2:
                accounts.add(new SavingsAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 3:
                accounts.add(new StudentAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 4:
                accounts.add(new BusinessAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 5:
                accounts.add(new SMBAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 6:
                accounts.add(new IRAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 7:
                accounts.add(new HighInterestAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 8:
                accounts.add(new IslamicAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 9:
                accounts.add(new PrivateAccount(name, accNumGenerator, id, loanReasons));
                break;
            case 10:
                accounts.add(new LCRAccount(name, accNumGenerator, id, loanReasons));
                break;
        }


    }


    public void deposit(int acc_number, double amount) {
        //Write the instruction to the user
        //System.out.println("Enter account Number: ");
//Convert the string the user enters to an int
        //  acc_num = Integer.parseInt(input.nextLine());
        //Write instruction to the user
        //System.out.println("Enter deposit amount: ");
//Convert the string entered by the user to a double
        // amount = Double.parseDouble(input.nextLine());

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == acc_number) {
                System.out.println(acc_number);

                accounts.get(i).deposit(amount);
                accounts.get(i).addTransaction(new Date(), "Deposit", amount);
                System.out.println(amount);
            }
        }
    }


    public double displayBalance(int acc_number) {
        //Write the instruction to the user
        //System.out.println("Enter account Number: ");
//Convert the string the user enters to an int
        //acc_number = Integer.parseInt(input.nextLine());


        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == acc_number) {
                amount = accounts.get(i).get_balance();
                accounts.get(i).addTransaction(new Date(), "View Balance", amount);


            }
        }

        return amount;
    }


    public double withdraw(int acc_number, double amount) {
        //Write the instruction to the user
        System.out.println("Enter account Number: ");
//Convert the string the user enters to an int
        //acc_number = Integer.parseInt(input.nextLine());
        //Write instruction to the user
        System.out.println("Enter deposit amount: ");
//Convert the string entered by the user to a double
        //amount = Double.parseDouble(input.nextLine());

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
        return amount;
    }


    public void transferMoney(int acc_number, double amount, int acc_number2) {              //Write the instruction to the user
        //System.out.println("Enter account Number to transfer money FROM:");
        //Convert the string the user enters to an int
        // acc_number = Integer.parseInt(input.nextLine());
        //Write instruction to the user
        //System.out.println("Enter transfer amount: ");
//Convert the string entered by the user to a double
        // amount = Double.parseDouble(input.nextLine());
        CareTaker careTaker = new CareTaker();
        int counter = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == acc_number) {
                counter++;

                if (accounts.get(i).get_balance() >= amount) {
                    careTaker.add(accounts.get(i).saveMemento());
                    accounts.get(i).withdraw(amount);
                    accounts.get(i).addTransaction(new Date(), "Transfer", amount);

                } else {

                    System.out.println("There are insufficient funds to make this transfer");
                    accounts.get(i).getStateFromMemento(careTaker.get(0));

                }
            } else if (counter == 0) { //if no valid account was found
                System.out.println("Account number not recognised.");
                accounts.get(i).getStateFromMemento(careTaker.get(0));
            }
        }


        System.out.println("Enter account Number to transfer money TO: ");
        //Convert the string the user enters to an int
        //  acc_number2 = Integer.parseInt(input.nextLine());
        int counterTwo = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == acc_number2) {
                counterTwo++;
                accounts.get(i).deposit(amount);
                accounts.get(i).addTransaction(new Date(), "Transfer", amount);

            } else if (counterTwo == 0) { //if no valid account was found
                System.out.println("Account number not recognised. No funds weretransferred.");
                //accounts.get(acc_number).deposit(amount); //put funds back in first account /***2.rollback feature***/
                accounts.get(i).getStateFromMemento(careTaker.get(0));
            }
        }

        System.out.println("Payment has been successfully transferred");


    }


    public void payInterest() {


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


    public List<String> showTransactions(int acc_number) {
        // System.out.println("Enter Account Number");
        // acc_num = Integer.parseInt(input.nextLine())
        List<String> transactionList = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == acc_number) {
                while (j < accounts.get(i).getTransactions().size()) {


                    transactionList.add(accounts.get(i).getTransactions().get(j).getType() + " " + accounts.get(i).getTransactions().get(j).getDate() + " " + accounts.get(i).getTransactions().get(j).getAmount());

                    j++;
                }

            }
        }
        return transactionList;

    }

    public void changeOverdraft(int accNum, int counter) {
        System.out.println("Enter Account Number:");
        accNum = Integer.parseInt(input.nextLine());
        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == accNum) {
                counter++;
                System.out.println("The current overdraft limit is �" + account.getOverdraft());
                System.out.println("The maximum allowed overdraft limit is �" + account.getOverdraftLimit());
                System.out.println("Enter new overdraft limit:");
                int limit = Integer.parseInt(input.nextLine());
                if (limit <= account.getOverdraftLimit()) {
                    account.changeOverdraft(limit);
                    account.addTransaction(new Date(), "New Overdraft Limit Set", limit);
                } else {
                    System.out.println("Please enter a value between 0 and " +
                            account.getOverdraftLimit());
                }
            }
        }
        if (counter == 0) { //if no valid account was found
            System.out.println("Account number not recognised.");
        }

    }

    public void chooseLoanType(int option, String name, int acc_num, int id, String loanReasons) {
        switch (option) {
            case 1:
                accounts.add(new Loan(name, acc_num, id, loanReasons));
                break;
            case 2:
                accounts.add(new BusinessLoan(name, acc_num, id, loanReasons));
                break;
            case 3:
                accounts.add(new StudentLoan(name, acc_num, id, loanReasons));
                break;
            case 4:
                accounts.add(new PersonalLoan(name, acc_num, id, loanReasons));
                break;
        }

    }


    public void createLoan(String name, int id, int accNum, int option, String loanReasons) {
        int counter = 0;
        final Penalty penalty = new Penalty();
        System.out.println("Enter customer's first and last name:");
        // name = input.nextLine();
        System.out.println("Enter Customer ID:");
        // id = Integer.parseInt(input.nextLine());
        System.out.println("Enter account number for funds to be paid into:");
        accNum = Integer.parseInt(input.nextLine());
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == accNum) {
                counter++;
                if ("Loan".equals(accounts.get(i).get_acc_type())) {
                    System.out.println("Funds must be paid into a bank account.");

                } else {
                    System.out.println("Enter loan amount:");
                    int loan = Integer.parseInt(input.nextLine());
                    if (option == 3) {
                        System.out.println("Enter loan amount:");
                        //int loan = Integer.parseInt(input.nextLine());
                        if (loan > 0 && loan <= 25000) {
                            accNumGenerator++;
                            //accounts.add(new Loan(name, accNumGenerator, id));
                            chooseLoanType(option, name, accNumGenerator, id, loanReasons);
                            accounts.get(accNumGenerator).setLoanAmount(loan);
                            System.out.println("Your loan account number is " + accNumGenerator);
                            accounts.get(accNumGenerator).addLoanTransaction(new Date(), "New Loan",
                                    loan, loanReasons);
                            accounts.get(accNumGenerator).withdraw(loan);
                            accounts.get(i).deposit(loan);
                            accounts.get(i).addTransaction(new Date(), "Loan", amount);
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < accounts.size(); i++) {
                                        double charge = accounts.get(i).accept(penalty);
                                        //interest visit

                                        accounts.get(i).addTransaction(new Date(), " Student Loan Payment", (charge));
                                    }
                                    //System.out.println("Interest has been paid.");
                                }
                            }, 30000, 30000);

                        } else if (loan > 25000) {
                            System.out.println("A Student Loan cannot exceed 25000");
                        }


                    } else if (loan > 0 && loan <= 100000) {
                        accNumGenerator++;
                        //accounts.add(new Loan(name, accNumGenerator, id));
                        chooseLoanType(option, name, accNumGenerator, id, loanReasons);
                        accounts.get(accNumGenerator).setLoanAmount(loan);
                        System.out.println("Your loan account number is " + accNumGenerator);
                        accounts.get(accNumGenerator).addLoanTransaction(new Date(), "New Loan",
                                loan, loanReasons);
                        accounts.get(accNumGenerator).withdraw(loan);
                        accounts.get(i).deposit(loan);
                        accounts.get(i).addTransaction(new Date(), "Loan", amount);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                for (int i = 0; i < accounts.size(); i++) {

                                    double charge = accounts.get(i).accept(penalty);
                                    //interest visit

                                    accounts.get(i).addTransaction(new Date(), "Loan Payment", (charge));
                                }
                                //System.out.println("Interest has been paid.");
                            }
                        }, 30000, 30000);

                    } else {
                        System.out.println("Please choose a value above zero up to �100,000");
                    }

                }
            }
            if (counter == 0) { //if no valid account was found
                System.out.println("Account number not recognised.");

            }
        }
    }

    public void viewLoanPaymentHistory(int accNum, int counter) {
        System.out.println("Enter Account Number:");
        // accNum = Integer.parseInt(input.nextLine());
        int h = 0;
        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == accNum) {
                counter++;
                if ("Loan".equals(account.get_acc_type())) {
                    while (h < account.getLoanPayments().size()) {
                        System.out.println(account.getLoanPayments().get(h).getLoanType() + " " + account.getLoanPayments().get(h).getLoanDate() + " " + account.getLoanPayments().get(h).getLoanAmount());
                        h++;
                    }
                } else {
                    System.out.println("Please enter a Loan account number.");
                }
            }
        }
        if (counter == 0) { //if no valid account was found
            System.out.println("Account number not recognised.");
        }
    }
}



