package org.example;

import java.util.Objects;
import java.util.Scanner;

public class AccountScanner {
    private int x;
    private Scanner scanner = new Scanner(System.in);
    private String accountName;
    private String accountType;

    public int inputMoney() {
        boolean i = true;
        while (i) {
            try {
                System.out.print("Введите размер счета, больше или равен 20_000 => ");
                x = Integer.parseInt(scanner.nextLine());
                if (x <= 0 || x >= 20_000) {
                    i = false;
                    System.out.println("Размер счета равен: " + x);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Введите целое число.");
            }
            System.out.println();
        }
        return x;
    }

    public int addMoney() {
        int amount = 0;
        boolean validInput = true;
        while (validInput) {
            try {
                System.out.print("Сумма вносимого депозита, больше или равна 10 => ");
                amount = Integer.parseInt(scanner.nextLine());
                if (amount < 0 || amount >= 10) {
                    validInput = false;
                    System.out.println("Размер вносимого депозита, равен: " + amount);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Введите целое число.");
            }
            System.out.println();
        }
        return amount;
    }

    public int outputMoney() {
        int amount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Сумма выводимых средств, больше 0 => ");
                amount = Integer.parseInt(scanner.nextLine());
//                if (amount < 0 || amount >= 0) {
                    validInput = true;
                    System.out.println("Размер выведенных средств: " + amount);
//                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Введите интовое целое число.");
            }
            System.out.println();
        }
        return amount;
    }

    public String getAccountNameFromUser() {
        System.out.print("Введите имя аккаунта. Дима или Маша => ");
        accountName = scanner.nextLine();

        if (!Objects.equals(accountName, "Дима")) {
            accountName = "Маша";
        }

        System.out.println("Имя аккаунта: " + accountName);
        System.out.println();
        return accountName;
    }

    public String typeOfAccount() {
        boolean i = true;
        while (i) {
            System.out.print("Введите тип аккаунта. debit - первый вариант 1 или credit - второй вариант 2 => ");
            accountType = scanner.nextLine().toLowerCase();
            if (Objects.equals(accountType, "debit") || Objects.equals(accountType, "credit")) {
                i = false;
                System.out.println("Тип аккаунта: " + accountType);
            } else {
                System.out.println("Ошибка: Некорректный ввод. Пожалуйста, выберите Debit или Credit.");
            }
            System.out.println();
        }
        return accountType;
    }

    public int numberSwitch() {
        boolean i = true;
        while (i) {
            try {
                x = Integer.parseInt(scanner.nextLine());
                if (x > 0 && x < 5) {
                    i = false;
                }else System.out.println("Ввведите число от 1 до 4, включительно");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Введите целое число.");
            }
            System.out.println();
        }
        return x;
    }


    // Закрытие Scanner после использования
    public void closeScanner() {
        scanner.close();
    }


}

