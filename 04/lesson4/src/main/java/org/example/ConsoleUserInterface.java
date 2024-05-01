package org.example;

import org.example.exceptions.IllegalArgumentException;
import org.example.exceptions.ImpossibleTransactionOperation;
import org.example.exceptions.InsufficientFundsException;

public class ConsoleUserInterface {


    private AccountActions accountActions;

    private Transaction transaction;

    public void consoleInterface() throws IllegalArgumentException, InsufficientFundsException {
        //        Черный: \u001B[30m
        //        Красный: \u001B[31m
        //        Зеленый: \u001B[32m
        //        Желтый: \u001B[33m
        //        Синий: \u001B[34m
        //        Пурпурный: \u001B[35m
        //        Голубой: \u001B[36m
        //        Белый: \u001B[37m
        // ANSI escape коды для цветов
        // System.out.print("\u001B[36m+"); // Голубой цвет
        // System.out.print("\u001B[31m+"); // Красный цвет
        // System.out.print("\u001B[32m+"); // Зеленый цвет
        // String resetColor = "\u001B[0m";  // Сброс цвета
        // System.out.println(resetColor); // Сброс цвета
        String greenColor = "\u001B[32m";

        String resetColor = "\u001B[0m";

        System.out.println(greenColor + "      #######  ####     ####       ####    #####   ##   ##  ####### ");
        System.out.println("       ##   #   ##       ##       ##  ##  ##   ##  ### ###   ##   # ");
        System.out.println(" ##   ##   ## #     ##       ##      ##       ##   ##  #######   ## #   ");
        System.out.println(" ## # ##   ####     ##       ##      ##       ##   ##  #######   ####   ");
        System.out.println(" #######   ## #     ##   #   ##   #  ##       ##   ##  ## # ##   ## #   ");
        System.out.println(" #######   ##   #   ##  ##   ##  ##   ##  ##  ##   ##  ##   ##   ##   # ");
        System.out.println("  ## ##   #######  #######  #######    ####    #####   ##   ##  ####### " + resetColor);
        accountActions = new AccountActions();

        System.out.println("\u001B[33m\n");
        System.out.println("Выберите действие:\n" +
                "1 - создать аккаунт\n" +
                "2 - добавить средства на аккаунт\n" +
                "3 - вывести средства с аккаунта\n" +
                "4 - осуществить транзакцию между аккаунтами\n ");

        System.out.println("\u001B[34m\n");
        AccountScanner accountScanner = new AccountScanner();
        int switch1 = accountScanner.numberSwitch();
        switch (switch1) {
            case 1:
                try {
                    accountActions.createAccount();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                accountActions.closeScanner();
                System.out.println();
                break;
            case 2:
                try {
                    System.out.println("Для начала нужно создать аккаунт и положить на него более 20_0000\n");
                    Account account = accountActions.createAccount();
                    accountActions.addMoneyToAccount(account);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                accountActions.closeScanner();
                System.out.println();
                break;
            case 3:
                try {
                    System.out.println("Для начала нужно создать аккаунт и положить на него более 20_0000\n");
                    Account account = accountActions.createAccount();
                    accountActions.getMoneyFromAccount(account);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InsufficientFundsException e) {
                    e.printStackTrace();
                }
                accountActions.closeScanner();
                System.out.println();
                break;
            default:
                transaction = new Transaction();
                Account account1 = transaction.preparingToTransaction();
                Account account2 = transaction.preparingToTransaction();
                try {
                    transaction.createTransaction(account1, account2);
                } catch (ImpossibleTransactionOperation e) {
                    e.printStackTrace();
                }
                accountActions.closeScanner();
                System.out.println();
                break;
        }

        System.out.println("\u001B[0m");
    }
}
