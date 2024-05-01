package org.example;

import org.example.exceptions.IllegalArgumentException;
import org.example.exceptions.ImpossibleTransactionOperation;
import org.example.exceptions.InsufficientFundsException;

public class Main {


    public static void main(String[] args) throws IllegalArgumentException, InsufficientFundsException {


        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();
        consoleUserInterface.consoleInterface();

    }
}














//        AccountActions accountActions = new AccountActions();
//
//        try {
//
//            accountActions.createAccount();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Account account = accountActions.createAccount();
//            accountActions.addMoneyToAccount(account);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            Account account = accountActions.createAccount();
//            accountActions.getMoneyFromAccount(account);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (InsufficientFundsException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        Transaction transaction = new Transaction();
//        Account account1 = transaction.preparingToTransaction();
//        Account account2 = transaction.preparingToTransaction();
//        try {
//            transaction.createTransaction(account1,account2);
//        } catch (ImpossibleTransactionOperation e) {
//            e.printStackTrace();
//        }
//
//        accountActions.closeScanner();