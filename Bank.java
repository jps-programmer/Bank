import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static final double SAVINGS_RATE = 0.20;
    private static final double CHECKING_RATE = 0.03;
    private static final double INVESTMENT_RATE = 0.50;
    private static final String BANK_NAME = "First Mutual";
    private double balance;
    private int accountNumber;
    private int routingNumber;
    private String accountHolder;
    private String key;
    private String accountType;

    public Bank(String accountHolder, String key, String accountType) {
        this.accountHolder = accountHolder;
        this.key = key;
        this.accountNumber = generateAccountNumber();
        this.routingNumber = generateRoutingNumber();

        if(accountType.equalsIgnoreCase("savings")) {
            this.accountType = "savings";
        } else if(accountType.equalsIgnoreCase("checking")) {
            this.accountType = "checking";
        } else if(accountType.equalsIgnoreCase("investment")) {
            this.accountType = "investment";
        }
    }

    public boolean checkName(String name) {
        return name.equalsIgnoreCase(this.accountHolder);
    }

    public boolean checkKey(String key) {
        return key.equals(this.key);
    }

    public String deposit(double amount) {
        this.balance += amount;
        return "Transaction complete\nCurrent Balance: " + String.format("$%.2f",getBalance());
    }

    public String withdrawal(double amount) {
        if(this.balance - amount >= 0) {
            this.balance -= amount;
            return "Transaction complete\nCurrent Balance: " + String.format("$%.2f",getBalance());
        }
        return "Withdrawal is greater than current account balance\nCurrent Balance: " +
                String.format("$%.2f",getBalance());
    }

    public String getAccountInformation(String accountHolder, String key) {
        String output = "";
        if(accountHolder.equalsIgnoreCase(this.accountHolder) && key.equals(this.key)) {
            output = "Account Holder: " + this.accountHolder + "\nAccount Number: " + this.accountNumber +
                "\nRouting Number: " + this.routingNumber + "\nCurrent Balance: " + String.format("$%.2f",this.balance);
        } else {
            output = "Invalid Information";
        }
        return output;
    }

    public String yearlyInterestGain() {
        String[] months = {"January","February","March","April","May","June","July","August","September","October",
                "November","December"};
        List<String> monthsList = new ArrayList<String>(List.of(months));
        String output = "";
        double accountBalance = getBalance();
        output += "Starting Balance: " + String.format("$%.2f",getBalance()) + "\n";
        if(getAccountType().equalsIgnoreCase("savings")) {
            for(int i = 1; i < 13; i++) {
                double holder = accountBalance * (SAVINGS_RATE / 100);
                accountBalance += holder;
                output += "" + monthsList.get(i - 1) + ": " + String.format("$%.2f",accountBalance) + "\n";
            }
        } else if(getAccountType().equalsIgnoreCase("checking")) {
            for(int i = 1; i < 13; i++) {
                double holder = accountBalance * (CHECKING_RATE / 100);
                accountBalance += holder;
                output += "" + monthsList.get(i - 1) + ": " + accountBalance + "\n";
            }
        } else if(getAccountType().equalsIgnoreCase("investment")) {
            for(int i = 1; i < 13; i++) {
                double holder = accountBalance * (INVESTMENT_RATE / 100);
                accountBalance += holder;
                output += "" + monthsList.get(i - 1) + ": " + accountBalance + "\n";
            }
        } else {
            output = "Invalid Account Type";
        }
        return output;
    }

    public String potentialYearlyInterestGain(double amount) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October",
                "November","December"};
        List<String> monthsList = new ArrayList<String>(List.of(months));
        String output = "";
        double accountBalance = amount;
        output += "Starting Balance: " + String.format("$%.2f",amount) + "\n";
        if(getAccountType().equalsIgnoreCase("savings")) {
            for(int i = 1; i < 13; i++) {
                double holder = accountBalance * (SAVINGS_RATE / 100);
                accountBalance += holder;
                output += "" + monthsList.get(i - 1) + ": " + String.format("$%.2f",accountBalance) + "\n";
            }
        } else if(getAccountType().equalsIgnoreCase("checking")) {
            for(int i = 1; i < 13; i++) {
                double holder = accountBalance * (CHECKING_RATE / 100);
                accountBalance += holder;
                output += "" + monthsList.get(i - 1) + ": " + accountBalance + "\n";
            }
        } else if(getAccountType().equalsIgnoreCase("investment")) {
            for(int i = 1; i < 13; i++) {
                double holder = accountBalance * (INVESTMENT_RATE / 100);
                accountBalance += holder;
                output += "" + monthsList.get(i - 1) + ": " + accountBalance + "\n";
            }
        } else {
            output = "Invalid Account Type";
        }
        return output;
    }

    private int generateAccountNumber() {
        int min = (int) Math.pow(10,8) - 1;
        int max = (int) Math.pow(10,(12 - 1));
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    private int generateRoutingNumber() {
        int min = (int) Math.pow(10,9) - 1;
        int max = (int) Math.pow(10,(9 - 1));
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public String getBankName() {
        return BANK_NAME;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        if(accountType.equalsIgnoreCase("savings") || accountType.equalsIgnoreCase("checking")
            || accountType.equalsIgnoreCase("investment")) {
            this.accountType = accountType;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceFormatted() {
        return String.format("$%.2f",getBalance());
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        }
    }

}
