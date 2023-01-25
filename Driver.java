import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

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

}
