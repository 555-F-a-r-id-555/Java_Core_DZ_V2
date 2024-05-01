package org.example;


import org.example.exceptions.IllegalArgumentException;
import org.example.exceptions.ImpossibleTransactionOperation;
import org.example.exceptions.InsufficientFundsException;

public class Transaction {

//    private final Account[] accounts;

    private Account account;
    private AccountActions accountActions;


    public Account preparingToTransaction() throws IllegalArgumentException {
        System.out.println("Для начала нужно создать аккаунт и положить на него более 20_0000\n");

        accountActions = new AccountActions();

        try {
            account = accountActions.createAccount();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
        return account;
    }


    public void createTransaction(Account account1, Account account2) throws InsufficientFundsException, ImpossibleTransactionOperation, IllegalArgumentException {

        System.out.println("4 варианта:");
        System.out.println("1 вариант, возможен - from DebitAccount to DebitAccount");
        System.out.println("2 вариант, возможен- from DebitAccount to CreditAccount");
        System.out.println("3 вариант, не возможен - from CreditAccount to DebitAccount");
        System.out.println("4 вариант, не возможен - from CreditAccount to CreditAccount\n");
        System.out.println("Вывод: если 1 аккаунт Debit - возможно, иначе нельзя\n");


        if (account1 instanceof CreditAccount){
            throw new ImpossibleTransactionOperation("Транзакцию осуществить не возможно между аккаунтом \n" + account1 + " и аккаунтом \n" + account2);
//            System.out.println("Транзакцию осуществить не возможно между аккаунтом \n" + account1 + " и аккаунтом \n" + account2);

        } else if (account1 instanceof DebitAccount) {
            int getMoney = 0;
            accountActions = new AccountActions();
            try {
                getMoney = accountActions.getMoneyFromAccountForTransaction(account1);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                throw e;
            } catch (InsufficientFundsException e) {
                e.printStackTrace();
                throw e;
            }

            try {
                accountActions.addMoneyToAccount(account2,getMoney);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            System.out.println("Операция прошла успешно");
        }
    }



}
