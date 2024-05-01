package org.example;


public class DebitAccount extends Account {

    private double annualPercentageRate;

    private int currentBalance;

    public DebitAccount(String accountName, String creationDateStr, int initialAccountBalance, int currentBalance, double annualPercentageRate) {
        super(accountName, creationDateStr, initialAccountBalance, currentBalance);
        this.annualPercentageRate = annualPercentageRate;
    }

    @Override
    public String toString() {
        return "DebitAccount{" +
                "accountName='" + super.getAccountName() + '\'' +
                ", creationDateStr='" + super.getCreationDateStr() + '\'' +
                ", initialAccountBalance='" + super.getInitialAccountBalance() + '\'' +
                ", currentBalance='" + super.getCurrentBalance() + '\'' +
                ", annualPercentageRate='" + annualPercentageRate + '\'' +
                '}';
    }



    public static void main(String[] args) {
        String accountName = "Debit-1";
        String creationDateStr = "2022-11-22";
        int initialAccountBalance = 20_000;
        int currentBalance = 20_154;
        double annualPercentageRate = 4.7;

        DebitAccount debitAccount1 = new DebitAccount(accountName, creationDateStr, initialAccountBalance, currentBalance, annualPercentageRate);

        System.out.println(debitAccount1);


//        long t = debitAccount1.getDaysSinceCreation("2022-11-22");
//        System.out.println("time = " + t);
//
//        int balance = debitAccount1.getBalance(initialAccountBalance, 4.7, "2022-11-22");
//        System.out.println("balance = " + balance);


    }


}
