package com.example.faraz_khan.bank2;

/**
 * Created by faraz-khan on 11/2/15.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Control {



    private static Control instance;
    private final Timer timer = new Timer();
    int acc_num;
    int accNumGenerator;
    double amount;
    String name;


    ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();

    public Control() {
        final Interest interest = new Interest();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < accounts.size(); i++) {
                    double charge = accounts.get(i).accept(interest);


                    accounts.get(i).addTransaction(new Date(), "Interest", (charge));
                }

            }
        }, 30000, 30000);


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


    public List<String> createAccount(int option2, String name, int id, String loanReasons) {

        accNumGenerator++;
        List<String> createAccountOutput = new ArrayList<>();
        switch (option2) {
            case 1:
                accounts.add(new CurrentAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Current Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 2:
                accounts.add(new SavingsAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Savings Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created! ");
                break;
            case 3:
                accounts.add(new StudentAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Student Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 4:
                accounts.add(new BusinessAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Business Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 5:
                accounts.add(new SMBAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your SMB Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created! ");
                break;
            case 6:
                accounts.add(new IRAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your IRA Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created! ");
                break;
            case 7:
                accounts.add(new HighInterestAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your High Interest Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 8:
                accounts.add(new IslamicAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Current Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created! ");
                break;
            case 9:
                accounts.add(new PrivateAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Private Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 10:
                accounts.add(new LCRAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your LCR Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 11:
                accounts.add(new InternationalAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your International Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 12:
                accounts.add(new DisabilityAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Disability Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created!");
                break;
            case 13:
                accounts.add(new ChildrensAccount(name, accNumGenerator, id, loanReasons));
                createAccountOutput.add("Your Childrens Account: ");
                createAccountOutput.add("Name: " + name);
                createAccountOutput.add("Account Number: " + accNumGenerator);
                createAccountOutput.add("ID: " + id);
                createAccountOutput.add("Has Successfully Been Created! ");
                break;
        }

        return createAccountOutput;
    }


    public List<String> deposit(int acc_number, double amount) {
        List<String> depositOutput = new ArrayList<>();
        int counter = 0;

        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == acc_number) {
                counter++;
                account.deposit(amount);
                depositOutput.add("Your Deopsit of: ");
                depositOutput.add("Amount: " + amount);
                depositOutput.add("To Account Number: " + acc_number);
                depositOutput.add("Has Been Successful!");
            }
            if ("Loan".equals(account.get_acc_type())) {
                account.addLoanTransaction(new Date(), "Loan Payment", amount, "");
                depositOutput.add("You have �" + -(account.getBalance()) + " of your loan still to pay off.");
            } else {
                account.addTransaction(new Date(), "Deposit", amount);
            }
            if (counter == 0) {
                depositOutput.add("Account number not recognised.");
                depositOutput.add("Please Try Again.");

            }

        }
        return depositOutput;
    }


    public List<String> displayBalance(int acc_number) {
        List<String> displayBalanceOutput = new ArrayList<>();
        int counter = 0;

        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == acc_number) {
                counter++;
                amount = account.get_balance();
                account.addTransaction(new Date(), "View Balance", amount);
                displayBalanceOutput.add("Your Current Balance is: ");
                displayBalanceOutput.add("Amount: " + amount);
                displayBalanceOutput.add("Your available balance is : " + (amount + account.getOverdraft()));
                displayBalanceOutput.add("Account Number: " + acc_number);


            }
            if (counter == 0) {
                displayBalanceOutput.add("Account number not recognised.");
                displayBalanceOutput.add("Please Try Again.");

            }

        }

        return displayBalanceOutput;
    }


    public List<String> withdraw(int acc_number, double amount) {
        List<String> withdrawOutput = new ArrayList<>();
        int counter = 0;

        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == acc_number) {
                counter++;

                if ((account.getBalance() + account.getOverdraft()) < amount) {

                    withdrawOutput.add("Insufficient funds. This transaction has been cancelled.");

                } else if (account.getWithdrawLimit() >= amount) {

                    account.withdraw(amount);
                    account.addTransaction(new Date(), "Withdraw", amount);
                    withdrawOutput.add("You Have Successfully Withdrawn: ");
                    withdrawOutput.add("Amount: " + amount);
                    withdrawOutput.add("New Balance: " + account.getBalance());
                    withdrawOutput.add("You Have Successfully Withdrawn: ");

                } else {
                    withdrawOutput.add("The maximum withdrawal for a " + account.get_acc_type() + "account is �" + account.getWithdrawLimit() + ". This transaction has been cancelled.");

                }
            }
        }
        if (counter == 0) {
            withdrawOutput.add("Account number not recognised.");
        }


        return withdrawOutput;
    }


    public List<String> transferMoney(int acc_number, double amount, int acc_number2) {
        List<String> transferMoneyOutput = new ArrayList<>();
        CareTaker careTaker = new CareTaker();

        int counter = 0;
        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == acc_number) {
                counter++;

                if (account.get_balance() >= amount) {
                    careTaker.add(account.saveMemento());
                    account.withdraw(amount);
                    account.addTransaction(new Date(), "Transfer", amount);

                } else {

                    transferMoneyOutput.add("There are insufficient funds to make this transfer");


                }
            } else if (counter == 0) {
                transferMoneyOutput.add("Account number not recognised.");

            }


            int counterTwo = 0;
            for (int j = 0; j < accounts.size(); j++) {
                if (accounts.get(j).getAccountNum() == acc_number2) {
                    counterTwo++;
                    accounts.get(j).deposit(amount);
                    accounts.get(j).addTransaction(new Date(), "Transfer", amount);

                }

            }
            if (counterTwo == 0) {
                account.getStateFromMemento(careTaker.get(0));
                transferMoneyOutput.add("Account number not recognised. No funds were transferred.");
                transferMoneyOutput.add("Your Funds Remain Intact Your Current Balance Is Still: " + account.get_balance());
                account.addTransaction(new Date(), "Transfer Unsucessful", amount);


            }


        }
        transferMoneyOutput.add("Payment has been successfully transferred: ");
        transferMoneyOutput.add("Amount: " + amount);
        transferMoneyOutput.add("From Account Number: " + acc_number);
        transferMoneyOutput.add("To Account Number: " + acc_number2);


        return transferMoneyOutput;
    }


    public List<String> addAccountHolder(int acc_number, String name) {
        int counter = 0;
        List<String> addAccountHolderList = new ArrayList<>();
        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == acc_number) {
                counter++;
                account.AddAccHolder(name, acc_number);
                addAccountHolderList.add("A New Account Holder Has Been Sucessfully Added: ");
                addAccountHolderList.add("Name: " + name);
                addAccountHolderList.add("Account Number: " + acc_number);

                break;
            }
        }
        if (counter == 0) {
            addAccountHolderList.add("Account number not recognised.");
        }

        return addAccountHolderList;
    }


    public List<String> showAccounts(int _id) {
        int counter = 0;
        List<String> accountsList = new ArrayList<>();
        for (BaseAccount account : accounts) {
            if (account.getID() == _id) {
                counter++;
                accountsList.add(account.get_acc_type() + " " + account.getHolderName() + " " + account.get_balance());

            }
            if (counter == 0) {
                accountsList.add("Account number not recognised.");
            }
        }
        return accountsList;


    }


    public List<String> showTransactions(int acc_number) {
        int counter = 0;
        List<String> transactionList = new ArrayList<>();
        int j = 0;

        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == acc_number) {
                counter++;
                while (j < account.getTransactions().size()) {


                    transactionList.add(account.getTransactions().get(j).getType() + " " + account.getTransactions().get(j).getDate() + " " + account.getTransactions().get(j).getAmount());

                    j++;
                }

            }
        }
        if (counter == 0) {
            transactionList.add("Account number not recognised.");
        }

        return transactionList;

    }

    public List<String> changeOverdraft(int accNum, int limit) {
        List<String> changeOverdraftList = new ArrayList<>();
        int counter = 0;

        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == accNum) {
                counter++;

                if (limit <= account.getOverdraftLimit()) {
                    account.changeOverdraft(limit);
                    account.addTransaction(new Date(), "New Overdraft Limit Set", limit);
                    changeOverdraftList.add("The new overdraft limit is :" + account.getOverdraft());
                    changeOverdraftList.add("The maximum allowed overdraft limit is :" + account.getOverdraftLimit());
                } else {
                    changeOverdraftList.add("This Exceeds The Maximum Overdraft Limit Please enter a value between 0 and " +
                            account.getOverdraftLimit());
                }
            }
        }
        if (counter == 0) {
            changeOverdraftList.add("Account number not recognised.");
        }

        return changeOverdraftList;

    }

    public String chooseLoanType(int option, String name, int id, final String loanReasons) {
        String loanType = "";
        accNumGenerator++;
        switch (option) {
            case 1:
                accounts.add(new Loan(name, accNumGenerator, id, loanReasons));
                loanType = "Standard";
                break;
            case 2:
                accounts.add(new BusinessLoan(name, accNumGenerator, id, loanReasons));
                loanType = "Business";
                break;
            case 3:
                accounts.add(new StudentLoan(name, accNumGenerator, id, loanReasons));
                loanType = "Student";
                break;
            case 4:
                accounts.add(new PersonalLoan(name, accNumGenerator, id, loanReasons));
                loanType = "Personal";
                break;
        }

        return loanType;

    }


    public List<String> createLoan(String name, int id, int accNum, int option, String loanReasons, int loan) {
        List<String> createLoanList = new ArrayList<>();
        int counter = 0;


        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == accNum) {
                counter++;
                if ("Loan".equals(account.get_acc_type())) {
                    createLoanList.add("Funds must be paid into a bank account.");

                } else {


                    if (loan > 0 && loan <= 100000) {

                        String loanType = chooseLoanType(option, name, id, loanReasons);
                        accounts.get(accNumGenerator - 1).setLoanAmount(loan);
                        createLoanList.add("Your " + loanType + " Loan Has Been Approved ");
                        createLoanList.add("Your loan account number is " + (accNumGenerator));
                        accounts.get(accNumGenerator - 1).addLoanTransaction(new Date(), "New Loan",
                                loan, "");
                        accounts.get(accNumGenerator - 1).withdraw(loan);
                        account.deposit(loan);
                        account.addTransaction(new Date(), "Loan", amount);
                    } else {
                        createLoanList.add("Please choose a value above zero up to �100,000");
                    }

                }
            }
        }
        if (counter == 0) {
            createLoanList.add("Account number not recognised.");

        }
        return createLoanList;
    }


    public List<String> viewLoan(int accNum) {
        List<String> viewLoanList = new ArrayList<>();
        int counter = 0;
        System.out.println("Enter Account Number:");

        int h = 0;
        for (BaseAccount account : accounts) {
            if (account.getAccountNum() == accNum) {
                counter++;
                if ("Loan".equals(account.get_acc_type())) {
                    viewLoanList.add("Loan Amount: " + account.getLoanAmount());
                    viewLoanList.add("Amount Due: " + account.get_balance());
                    viewLoanList.add("Monthly Payment: " + (account.get_balance() / 36) + "Pounds For 36 Months");
                    viewLoanList.add("Name: " + account.getHolderName());
                    while (h < account.getLoanPayments().size()) {
                        System.out.println(account.getLoanPayments().get(h).getLoanType() + " " + account.getLoanPayments().get(h).getLoanDate() + " " + account.getLoanPayments().get(h).getLoanAmount());
                        h++;
                    }
                } else {
                    viewLoanList.add("Please enter a Loan account number.");
                }
            }
        }
        if (counter == 0) {
            viewLoanList.add("Account number not recognised.");
        }
        return viewLoanList;
    }
}



