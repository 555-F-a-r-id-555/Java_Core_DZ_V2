package org.example;

public class CreditAccount extends Account{
    public CreditAccount(String accountName, String creationDateStr, int initialAccountBalance, int currentBalance) {
        super(accountName, creationDateStr, initialAccountBalance, currentBalance);
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "accountName='" + super.getAccountName() + '\'' +
                ", creationDateStr='" + super.getCreationDateStr() + '\'' +
                ", initialAccountBalance='" + super.getInitialAccountBalance() + '\'' +
                ", currentBalance='" + super.getCurrentBalance() + '\'' +
                '}';
    }


//    public CreditAccount(String accountName, String creationDateStr, int initialAccountBalance) {
//        super(accountName, creationDateStr, initialAccountBalance);
//    }

    public static void main(String[] args) {
        String accountName = "Credit-1";
        String creationDateStr = "2022-11-22";
        int initialAccountBalance = 20_000;
        int currentBalance = 20_154;
        CreditAccount creditAccount1 = new CreditAccount(accountName, creationDateStr, initialAccountBalance,currentBalance);

        System.out.println(creditAccount1);


//        long t = creditAcciunt1.getDaysSinceCreation();
//        System.out.println("time = " + t);




    }
}
