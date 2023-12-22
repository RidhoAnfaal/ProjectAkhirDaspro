
/**
 * Final project : Banking system 
 * Group Member : 1. Bayu 
 *                2. Hammam 
 *                3. Ridho
 * Class : TI 1I
 */

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BankingSystem {
    static Scanner input = new Scanner(System.in);

    // Format rupiah
    static Locale localeID = new Locale("in", "ID");
    static NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    // Var for register & login
    static String[] usernameArray = new String[100];
    static String[] passwordArray = new String[100];
    static int age, genderBolean;
    static String username, password, name, address, phonenumber;

    // MAIN FITURES VAR
    static double[] balanceArray = new double[100];
    static double[] loanArray = new double[100];
    static double[] remainingdebtArray = new double[100];
    static double[] monthlyInstallmentsArray = new double[100];
    static double[] monthlyInterestArray = new double[100];
    static double[] totalDebttobePaidArray = new double[100];
    static double[] remainingInstallmentsArray = new double[100];
    static double[] loanRepaymentArray = new double[100];
    static String[] txTypeArray = new String[100];
    static double[] txAmountArray = new double[100];

    static boolean approval, tfBalance;
    static int loanTerm, menu, month, loanApplication;
    static double interest = 0.005, remainingBalance = 0.0, monthlyInterest = 0.0, monthlyInstallments = 0.0,
            loanAmount = 0.0, remainingdebt = 0.0, totalDebttobePaid = 0.0, remainingInstallments = 0.0,
            loanRepayment = 0.0;

    static int txIndex = 0;

    // Main function
    public static void main(String[] args) {
        int menu, index = 0;

        // title
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗\r\n" + //
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝\r\n" + //
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  \r\n" + //
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  \r\n" + //
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗\r\n" + //
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝\r\n" + //
                "                                                              ");

        do {
            System.out.println("\r\n" + //
                    "+---------------------+\r\n" + //
                    "| PLEASE CHOOSE MENU  |\r\n" + //
                    "+---------------------+\r\n" + //
                    "| 1. Registration     |\r\n" + //
                    "| 2. Login            |\r\n" + //
                    "| 3. Exit             |\r\n" + //
                    "+---------------------+");
            System.out.print("=== Choose the number: ");
            menu = input.nextInt();

            switch (menu) {
                // REGISTER
                case 1:
                    System.out.print("Enter your username: ");
                    username = input.next();
                    System.out.print("Enter your password: ");
                    password = input.next();
                    System.out.println("=====================================");
                    System.out.print("Enter your name: ");
                    name = input.next();
                    System.out.print("Enter your age: ");
                    age = input.nextInt();

                    if (age < 18) {
                        System.out.println("You are not old enough!");
                        break;
                    }

                    System.out.print("Enter your gender (male:1, female:0): ");
                    genderBolean = input.nextInt();
                    System.out.print("Enter your phone number: ");
                    phonenumber = input.next();

                    System.out.print("Enter your address: ");
                    address = input.next();

                    usernameArray[index] = username;
                    passwordArray[index] = password;
                    index++;

                    String genderCard, male = "Male", female = "Female";
                    if (genderBolean == 1) {
                        genderCard = male;
                    } else {
                        genderCard = female;
                    }

                    System.out.println("\r\n" + //
                            "           ID CARD         \r\n" + //
                            " =============================== \r\n" + //
                            "  Name:    \t" + name + "\r\n" + //
                            "  Gender:    \t" + genderCard + "\r\n" + //
                            "  Age:     \t" + age + "\r\n" + //
                            "  Phone:   \t" + phonenumber + "\r\n" + //
                            "  Address: \t" + address + "\r\n" + //
                            " ===============================");
                    System.out.println("\s== REGISTRATION SUCCESSFUL ==\n");
                    break;

                // LOGIN
                case 2:
                    System.out.println("\n-- LOGIN --");
                    ;
                    System.out.print("Enter your username: ");
                    username = input.next();
                    System.out.print("Enter your password: ");
                    password = input.next();

                    for (int i = 0; i < index; i++) {
                        if (username.equals(usernameArray[i]) && password.equals(passwordArray[i])) {
                            System.out.println("\n== LOGIN SUCCESSFUL ==");
                            menu = 0;
                            do {
                                loggedin();
                            } while (menu != 0);
                            break;
                        }
                    }

                    if (menu != 0) {
                        System.out.println("\nXX INVALID XX");
                    }
                    break;

                // Exit
                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("sorry cant help you");
                    break;
            }
        } while (menu != 3);
    }

    public static void loggedin() {
        int index = 0;

        do {
            System.out.println("\r\n" + //
                    "+---------------------+\r\n" + //
                    "| PLEASE CHOOSE MENU  |\r\n" + //
                    "+---------------------+\r\n" + //
                    "| 1. Input balance    |\r\n" + //
                    "| 2. Loan application |\r\n" + //
                    "| 3. Loan repayment   |\r\n" + //
                    "| 4. Balance check    |\r\n" + //
                    "| 5. Withdraw balance |\r\n" + //
                    "| 6. TX history       |\r\n" + //
                    "| 0. Exit             |\r\n" + //
                    "+---------------------+");
            System.out.print("=== Choose the number: ");
            menu = input.nextInt();

            switch (menu) {
                // INPUT BALANCE
                case 1:
                    System.out.println("\r\n" + //
                            "╔═════════╗\r\n" + //
                            "║ BALANCE ║\r\n" + //
                            "╚═════════╝\r\n" + //
                            "" + //
                            "");

                    System.out.print("Do you want to input balance? (true/false): ");
                    tfBalance = input.nextBoolean();

                    if (tfBalance == true) {
                        System.out.print("The balance amount you want to input: Rp");
                        remainingBalance = input.nextDouble();
                        System.out.println("\n== YOUR BALANCE ENTRY REQUEST HAS BEEN SUBMITTED ==");
                        balanceArray[index] = remainingBalance;

                    } else if (tfBalance == false) {
                        remainingBalance = 0;
                        balanceArray[index] = remainingBalance;
                    }

                    index++;
                    txTypeArray[txIndex] = "Deposit";
                    txAmountArray[txIndex] = remainingBalance;
                    txIndex++;
                    break;

                // LOAN APPLICATION
                case 2:
                    System.out.println("\r\n" + //
                            "╔══════════════════╗\r\n" + //
                            "║ LOAN APPLICATION ║\r\n" + //
                            "╚══════════════════╝\r\n" + //
                            "" + //
                            "");

                    System.out.print("How much loan amount you want: Rp.");
                    loanAmount = input.nextDouble();
                    System.out.print("How long is your proposed payback period (months): ");
                    loanTerm = input.nextInt();
                    System.out.print(
                            "Are you willing to bear the cost of repaying the loan at 5% interest per year? (true/false): ");
                    approval = input.nextBoolean();

                    if (approval == false) {
                        System.out.println("\n== THANK YOU ==\n");
                        break;
                    }

                    remainingdebtArray[index] = remainingdebt;
                    loanArray[index] = loanAmount;
                    balanceArray[index] = remainingBalance;
                    monthlyInterestArray[index] = monthlyInterest;
                    remainingdebtArray[index] = remainingdebt;
                    totalDebttobePaidArray[index] = totalDebttobePaid;
                    monthlyInstallmentsArray[index] = monthlyInstallments;
                    index++;

                    // CALCULATE
                    for (int i = 1; i < index; i++) {
                        remainingdebtArray[i] = loanArray[i] - balanceArray[i];
                        monthlyInterestArray[i] = loanTerm * interest * remainingdebtArray[i];
                        totalDebttobePaidArray[i] = monthlyInterestArray[i] + remainingdebtArray[i];
                        monthlyInstallmentsArray[i] = totalDebttobePaidArray[i] / loanTerm;

                        System.out.println("\n== LOAN REQUEST APPROVED ==\n");

                        System.out.println("\r\n" +
                                " ======================================================================= \r\n" + //
                                "  Your interest per month " + formatRupiah.format(monthlyInterestArray[i]) + "\r\n" + //
                                "  The bill you have to pay per month amounts to "
                                + formatRupiah.format(monthlyInstallmentsArray[i]) + "\r\n" + //
                                " ======================================================================= ");

                        System.out.println("\n== THANK YOU ==\n");
                    }
                    txTypeArray[txIndex] = "Loan Application";
                    txAmountArray[txIndex] = loanAmount;
                    txIndex++;
                    // index++;
                    break;

                // LOAN REPAYMENT
                case 3:
                    for (int i = 1; i < index; i++) {
                        System.out.println("\r\n" + //
                                "╔════════════════╗\r\n" + //
                                "║ LOAN REPAYMENT ║\r\n" + //
                                "╚════════════════╝\r\n" + //
                                "" + //
                                "");

                        System.out.println("\r\n" +
                                " ====================================================================== \r\n" + //
                                "  The loan amount you have to pay is:"
                                + formatRupiah.format(totalDebttobePaidArray[i])
                                + "\r\n" + //
                                "  The loan amount you are required to pay monthly is:"
                                + formatRupiah.format(monthlyInstallmentsArray[i]) + "\r\n" + //
                                " ====================================================================== \r\n" + //
                                "\r\n" + //
                                "");

                        boolean tfRepayment = true;
                        System.out.print("Do you want to pay the loan bill? (true/false)");
                        tfRepayment = input.nextBoolean();
                        if (tfBalance == false) {
                            continue;
                        }

                        System.out.print("How much you want to pay: Rp");
                        loanRepayment = input.nextDouble();
                        loanRepaymentArray[index] = loanRepayment;

                        remainingInstallmentsArray[i] = totalDebttobePaidArray[i]
                                - loanRepayment;
                        totalDebttobePaidArray[i] = totalDebttobePaidArray[i]
                                - loanRepayment;

                        System.out.println("# Your installment payment has been received #");
                        System.out.println("\r\n" + //
                                " =================================================================================== \r\n"
                                + //
                                "  The remaining loan that you have to pay now is:"
                                + formatRupiah.format(remainingInstallmentsArray[i]) + "\r\n" + //
                                " =================================================================================== \r\n"
                                + //
                                "\r\n" + //
                                "");
                        System.out.println("== THANK YOU FOR PAYING THE INSTALLMENT ==\n");
                    }

                    txTypeArray[txIndex] = "Loan Repayment";
                    txAmountArray[txIndex] = loanRepayment;
                    txIndex++;
                    break;

                // BALANCE CHECHK
                case 4:
                    System.out.println("\r\n" + //
                            "╔═══════════════╗\r\n" + //
                            "║ BALANCE CHECK ║\r\n" + //
                            "╚═══════════════╝\r\n" + //
                            "" + //
                            "");

                    for (int i = 1; i < index; i++) {
                        System.out.println("" + //
                                " ============================================== \r\n" + //
                                "  Account balance:" + formatRupiah.format(balanceArray[i]) + "\r\n" + //
                                " ============================================== \r\n" + //
                                "\r\n" + //
                                "");
                    }
                    break;

                // WHITDRAW BALANCE
                case 5:
                    System.out.println("\r\n" + //
                            "╔══════════════════╗\r\n" + //
                            "║ WITHDRAW BALANCE ║\r\n" + //
                            "╚══════════════════╝\r\n" + //
                            "" + //
                            "");

                    System.out.print("Enter the amount of money you want to withdraw: Rp");
                    double withdrawalAmount = input.nextDouble();

                    for (int i = 1; i < index; i++) {
                        if (balanceArray[i] >= withdrawalAmount) {
                            balanceArray[i] -= withdrawalAmount;

                            // txHistory[txIndex][0] = -withdrawalAmount; // Negative value for withdrawal
                            // txIndex++;

                            System.out.println("\r\n" + //
                                    " ========================================================================== \r\n" + //
                                    "  Withdrawal Successful! Your new balance is:"
                                    + formatRupiah.format(balanceArray[i]) + "\r\n" + //
                                    " ========================================================================== \r\n" + //
                                    "\r\n" + //
                                    "");
                        } else {
                            System.out.println("\nInsufficient account balance!");
                        }
                    }
                    txTypeArray[txIndex] = "Balance Withdrawal";
                    txAmountArray[txIndex] = withdrawalAmount;
                    txIndex++;
                    break;

                case 6:
                    viewTransactionHistory();
                    break;

                default:
                    break;
            }
        } while (menu != 0);
    }

    public static void viewTransactionHistory() {
        System.out.println("\r\n" + //
                "╔═════════════════════╗\r\n" + //
                "║ TRANSACTION HISTORY ║\r\n" + //
                "╚═════════════════════╝\r\n" + //
                "");

        System.out.println("" + //
                "+------------------------------------------+---------------------------------------+\r\n" + //
                "| TRANSACTION TYPE:                        | TRANSACTION AMOUNT:                   |\r\n" + //
                "+------------------------------------------+---------------------------------------+");

        for (int i = 0; i < txIndex; i++) {
            System.out.println("| " + padRight(txTypeArray[i], 41) + "| "
                    + padRight(formatRupiah.format(txAmountArray[i]), 37) + " |");
        }

        System.out.println("" +
                "+------------------------------------------+---------------------------------------+\r\n" +
                "\r\n" +
                "");
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}