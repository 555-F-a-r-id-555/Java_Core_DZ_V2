package org.example;


//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class Account {

//    private static int counter = 0;

    private String accountName;

    private String creationDateStr;

    public String getCreationDateStr() {
        return creationDateStr;
    }

//    private LocalDateTime creationDate;

    private int initialAccountBalance;

    public void setInitialAccountBalance(int initialAccountBalance) {
        this.initialAccountBalance = initialAccountBalance;
    }

    public int getInitialAccountBalance() {
        return initialAccountBalance;
    }

    private int currentBalance;

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    //    private double annualPercentageRate;

    public String getAccountName() {
        return accountName;
    }

//    public LocalDateTime getCreationDate() {
//        return creationDate;
//    }

//    /**
//     * @param creationDate
//     */
//    public void setCreationDate(LocalDateTime creationDate) {
//        this.creationDate = creationDate;
//    }


    public Account(String accountName, String creationDateStr, int initialAccountBalance, int currentBalance) {
        this.accountName = accountName;
        this.creationDateStr = creationDateStr;
        this.initialAccountBalance = initialAccountBalance;
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", creationDateStr='" + creationDateStr + '\'' +
                ", initialAccountBalance=" + initialAccountBalance +
                ", currentBalance=" + currentBalance +
                '}';
    }


}

//    public Account(String accountName, String creationDateStr, int initialAccountBalance, int currentBalance) {
//        this.accountName = accountName;
//        this.creationDateStr = creationDateStr;
//        this.initialAccountBalance = initialAccountBalance;
//        this.currentBalance = currentBalance;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        creationDate = LocalDateTime.parse(creationDateStr + "T00:00:00", formatter);
//        setCreationDate(creationDate);
//    }

//    public long getDaysSinceCreation(String creationDateStr) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        creationDate = LocalDateTime.parse(creationDateStr + "T00:00:00", formatter);
//        LocalDateTime now = LocalDateTime.now();
//        Duration duration = Duration.between(creationDate, now);
//        return duration.toDays();
//    }


//    @Override
//    public String toString() {
//        return "Account{" +
//                "accountName='" + accountName + '\'' +
//                ", creationDateStr='" + creationDateStr + '\'' +
//                ", initialAccountBalance=" + initialAccountBalance +
//                '}';
//    }