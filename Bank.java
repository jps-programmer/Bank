import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A Simulation of a Bank's common operations
 *
 * @author Jameson Sisk (jps-programmer)
 */
public class Bank {

    //Private Fields//
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

    //Constructor//

    /**
     * Constructs a new instance of the Bank class
     * @param accountHolder to indicate the name of the account holder
     * @param key to indicate the password to the account
     * @param accountType to indicate the type of account
     */
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

    //Public Methods//

    /**
     * Checks the given String to ensure it matches accountHolder
     * @param name to indicate the provided name for the account holder
     * @return boolean
     */
    public boolean checkName(String name) {
        return name.equalsIgnoreCase(this.accountHolder);
    }

    /**
     * Checks the given key to ensure it matches key
     * @param key to indicate the provided key for the account
     * @return boolean
     */
    public boolean checkKey(String key) {
        return key.equals(this.key);
    }

    /**
     * Adds a certain amount of money to the account and returns a confirmatory message
     * @param amount to indicate the amount to be added
     * @return String
     */
    public String deposit(double amount) {
        this.balance += amount;
        return "Transaction complete\nCurrent Balance: " + String.format("$%.2f",getBalance());
    }

    /**
     * Withdraws a certain amount of money from the account and returns a confirmatory message if successful
     * @param amount to indicate the amount to be withdrawn
     * @return String
     */
    public String withdrawal(double amount) {
        if(this.balance - amount >= 0) {
            this.balance -= amount;
            return "Transaction complete\nCurrent Balance: " + String.format("$%.2f",getBalance());
        }
        return "Withdrawal is greater than current account balance\nCurrent Balance: " +
                String.format("$%.2f",getBalance());
    }

    /**
     * Gets the information for the current account if provided parameters are correct
     * @param accountHolder to indicate the name of the current account holder
     * @param key to indicate the key for the current account
     * @return String
     */
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

    /**
     * Returns the potential yearly interest gain for each month based on the current account balance
     * @return String
     */
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

    /**
     * Returns the yearly interest gain by month based on a potential account balance
     * @param amount to indicate the potential account balance
     * @return String
     */
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

    /**
     * Returns the bank name
     * @return String
     */
    public String getBankName() {
        return BANK_NAME;
    }

    /**
     * Returns the account type
     * @return String
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the bank account type
     * @param accountType to indicate account type
     */
    public void setAccountType(String accountType) {
        if(accountType.equalsIgnoreCase("savings") || accountType.equalsIgnoreCase("checking")
            || accountType.equalsIgnoreCase("investment")) {
            this.accountType = accountType;
        }
    }

    /**
     * Returns the balance of the current account
     * @return double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the balance of the current account with US currency formatting
     * @return String
     */
    public String getBalanceFormatted() {
        return String.format("$%.2f",getBalance());
    }

    /**
     * Sets the balance to a certain non-negative amount
     * @param balance to indicate the amount the account balance to be set to
     */
    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        }
    }

    /**
     * Runs a series of commands to allow interaction with the Bank class
     */
    public static void run() {
        boolean interacting = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello and welcome!");
        System.out.print("Please enter your name: ");
        String name = scan.nextLine();
        System.out.print("Please enter a password for your account: ");
        String password = scan.nextLine();
        System.out.print("Please choose either \"savings\",\"checking\", or \"investment\": ");
        String type = scan.nextLine();
        System.out.print("Please enter your starting balance: ");
        double balance = scan.nextDouble();
        scan.nextLine();

        Bank one = new Bank(name,password,type);

        one.setBalance(balance);

        while(interacting) {
            System.out.print("Please enter your choice from the following options:\nYearly interest growth\nPotential" +
                    " yearly interest growth\nDeposit\nWithdrawal\nGet account information\nCheck balance\nExit\n");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("yearly interest growth")) {
                System.out.print("Please enter account holder: ");
                String holderAnswer = scan.nextLine();
                if(one.checkName(holderAnswer)) {
                    System.out.print("Please enter account password: ");
                    String holderKey = scan.nextLine();
                    if(one.checkKey(holderKey)) {
                        System.out.println(one.yearlyInterestGain());
                    } else {
                        System.out.println("Password is incorrect");
                    }
                } else {
                    System.out.println("Account holder is incorrect");
                }
            } else if(answer.equalsIgnoreCase("potential yearly interest growth")) {
                System.out.print("Please enter enter potential account balance: ");
                double potentialBalance = scan.nextDouble();
                if(potentialBalance > 0) {
                    System.out.println(one.potentialYearlyInterestGain(potentialBalance));
                    scan.nextLine();
                } else {
                    System.out.println("Potential account balance must be greater than zero");
                }
            } else if(answer.equalsIgnoreCase("deposit")) {
                System.out.print("Please enter account holder: ");
                String holderAnswer = scan.nextLine();
                if(one.checkName(holderAnswer)) {
                    System.out.print("Please enter account password: ");
                    String holderKey = scan.nextLine();
                    if(one.checkKey(holderKey)) {
                        System.out.print("Please enter amount to deposit: ");
                        double deposit = scan.nextDouble();
                        if(deposit > 0) {
                            System.out.println(one.deposit(deposit));
                            scan.nextLine();
                        } else {
                            System.out.println("Amount must be greater than zero");
                        }
                    } else {
                        System.out.println("Password is incorrect");
                    }
                } else {
                    System.out.println("Account holder is incorrect");
                }
            } else if(answer.equalsIgnoreCase("withdrawal")) {
                System.out.print("Please enter account holder: ");
                String holderAnswer = scan.nextLine();
                if(one.checkName(holderAnswer)) {
                    System.out.print("Please enter account password: ");
                    String holderKey = scan.nextLine();
                    if(one.checkKey(holderKey)) {
                        System.out.print("Please enter amount to withdrawal: ");
                        double withdrawal = scan.nextDouble();
                        if(withdrawal > 0) {
                            System.out.println(one.withdrawal(withdrawal));
                            scan.nextLine();
                        } else {
                            System.out.println("Amount must be greater than zero");
                        }
                    } else {
                        System.out.println("Password is incorrect");
                    }
                } else {
                    System.out.println("Account holder is incorrect");
                }
            } else if(answer.equalsIgnoreCase("get account information")) {
                System.out.print("Please enter account holder: ");
                String holderAnswer = scan.nextLine();
                if(one.checkName(holderAnswer)) {
                    System.out.print("Please enter account password: ");
                    String holderKey = scan.nextLine();
                    if(one.checkKey(holderKey)) {
                        System.out.println(one.getAccountInformation(holderAnswer,holderKey));
                    } else {
                        System.out.println("Password is incorrect");
                    }
                } else {
                    System.out.println("Account holder is incorrect");
                }
            } else if(answer.equalsIgnoreCase("check balance")) {
                System.out.print("Please enter account holder: ");
                String holderAnswer = scan.nextLine();
                if(one.checkName(holderAnswer)) {
                    System.out.print("Please enter account password: ");
                    String holderKey = scan.nextLine();
                    if(one.checkKey(holderKey)) {
                        System.out.println(one.getBalanceFormatted());
                    } else {
                        System.out.println("Password is incorrect");
                    }
                } else {
                    System.out.println("Account holder is incorrect");
                }
            } else if(answer.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for banking with " + one.getBankName());
                interacting = false;
            } else {
                System.out.println("Invalid option, please try again\n");
            }
        }
    }

    //Private Methods//

    /**
     * Generates a unique account number
     * @return int
     */
    private int generateAccountNumber() {
        int min = (int) Math.pow(10,8) - 1;
        int max = (int) Math.pow(10,(12 - 1));
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    /**
     * Generates a unique routing number
     * @return int
     */
    private int generateRoutingNumber() {
        int min = (int) Math.pow(10,9) - 1;
        int max = (int) Math.pow(10,(9 - 1));
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

}
