package org.example;

import org.example.exceptions.IllegalArgumentException;
import org.example.exceptions.InsufficientFundsException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AccountActions {

    private static int counter = 0;

    private String accountName;
    private final AccountScanner accountScanner = new AccountScanner();

    private final Users[] USERS = {
            new Users("Дима", 28, "+8-111-111-111", 50_000),
            new Users("Маша", 25, "+8-888-111-111", 58_000)
    };

    private final String[] TypeOfAccount = {"debit", "credit"};

    private final String[] CreationDateStr = {"2022-11-22",
            "2023-10-10"};

    private final double annualPercentageRate = 4.7;
    private LocalDateTime creationDate;


    public long getDaysSinceCreation(String creationDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        creationDate = LocalDateTime.parse(creationDateStr + "T00:00:00", formatter);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(creationDate, now);
        return duration.toDays();
    }

    /**
     * @param - 4.7 - годовая ставка
     *          M - сумма на конец срока, включая сумму открытия и начисленный процент,
     *          p - первоначальный размер депозита
     *          4.7 - годовая ставка
     *          356 - количество дней в году — 365 или 366.
     *          t - срок вложения в днях
     * @return M = p*(1+ (4.7/100)/356)^T - Ежедневная капитализация
     * <p>
     */
    public int getBalance(int initialAccountBalance, String creationDateStr) {
        long daysSinceCreation = getDaysSinceCreation(creationDateStr);
        System.out.println("daysSinceCreation = " + daysSinceCreation);
        return (int) (initialAccountBalance * (Math.pow((1 + (annualPercentageRate / 100) / 356), daysSinceCreation)));
    }


    public Account createAccount() throws IllegalArgumentException {
        String name = accountScanner.getAccountNameFromUser();
        int inputMoney = accountScanner.inputMoney();

        if (inputMoney <= 0) {
            throw new IllegalArgumentException("Размер счета не может быть меньше или равняться 0 => " + inputMoney);
        }

        System.out.println();
        String accountType = accountScanner.typeOfAccount();
//        System.out.println("accountType = " + accountType);

        counter++;
        String accountName = new StringBuilder().append(name).append("№").append(counter).append(accountType).toString();

        Account account;
        if (Objects.equals(accountType, TypeOfAccount[0])) {

            if (Objects.equals(name, USERS[0].getName())) {
                int currentBalance = getBalance(inputMoney, CreationDateStr[0]);
                account = new DebitAccount(accountName, CreationDateStr[0], inputMoney, currentBalance, annualPercentageRate);
                System.out.println("currentBalance = " + currentBalance);

            } else {
                int currentBalance = getBalance(inputMoney, CreationDateStr[1]);
                account = new DebitAccount(accountName, CreationDateStr[1], inputMoney, currentBalance, annualPercentageRate);
                System.out.println("currentBalance = " + currentBalance);
            }
        } else {
            if (Objects.equals(name, USERS[0].getName())) {
                account = new CreditAccount(accountName, CreationDateStr[0], inputMoney, inputMoney);
            } else {
                account = new CreditAccount(accountName, CreationDateStr[1], inputMoney, inputMoney);
            }

        }
        System.out.println(account);
        System.out.println();
        return account;
    }

    public void addMoneyToAccount(Account account) throws IllegalArgumentException {
//        System.out.println("Для начала нужно создать аккаунт и положить на него более 20_0000");
//        Account account = createAccount();
        int addMoney = accountScanner.addMoney();

        if (addMoney < 0) {
            throw new IllegalArgumentException("Размер депозита не может быть меньше 0 => " + addMoney);
        }

        int currentBalance = account.getCurrentBalance();
        System.out.println("Текущий баланс (до обновления): " + currentBalance);
        account.setCurrentBalance(currentBalance + addMoney);
        System.out.println("Теущий баланс (после обновления): " + account.getCurrentBalance());

    }

    public void addMoneyToAccount(Account account,int addMoney) throws IllegalArgumentException {

        if (addMoney < 0) {
            throw new IllegalArgumentException("Размер депозита не может быть меньше 0 => " + addMoney);
        }

        int currentBalance = account.getCurrentBalance();
        System.out.println("Текущий баланс (до обновления): " + currentBalance);
        account.setCurrentBalance(currentBalance + addMoney);
        System.out.println("Теущий баланс (после обновления): " + account.getCurrentBalance());

        System.out.println();
    }

    public void getMoneyFromAccount(Account account) throws IllegalArgumentException, InsufficientFundsException {

//        System.out.println("Для начала нужно создать аккаунт и положить на него более 20_0000");
//        Account account = createAccount();
        int getMoney = accountScanner.outputMoney();

        if (getMoney < 0) {
            throw new IllegalArgumentException("Размер выводимых средств не может быть меньше 0 => " + getMoney);
        } else if (getMoney > account.getCurrentBalance()) {
            throw new InsufficientFundsException("Размер выводимых средств => " + getMoney + " не может быть, больше => " + account.getCurrentBalance());
        }

        int currentBalance = account.getCurrentBalance();
        System.out.println("Текущий баланс (до обновления): " + currentBalance);
        account.setCurrentBalance(currentBalance - getMoney);
        System.out.println("Теущий баланс (после обновления): " + account.getCurrentBalance());

    }

    public int getMoneyFromAccountForTransaction(Account account) throws IllegalArgumentException, InsufficientFundsException {

        int getMoney = accountScanner.outputMoney();

        if (getMoney < 0) {
            throw new IllegalArgumentException("Размер выводимых средств не может быть меньше 0 => " + getMoney);
        } else if (getMoney > account.getCurrentBalance()) {
            throw new InsufficientFundsException("Размер выводимых средств => " + getMoney + " не может быть, больше => " + account.getCurrentBalance());
        }

        int currentBalance = account.getCurrentBalance();
        System.out.println("Текущий баланс (до обновления): " + currentBalance);
        account.setCurrentBalance(currentBalance - getMoney);
        System.out.println("Теущий баланс (после обновления): " + account.getCurrentBalance());
        System.out.println();

        return getMoney;
    }


    public void transactionBetweenAccounts() {

    }


    public void closeScanner() {
        accountScanner.closeScanner();
    }
}
