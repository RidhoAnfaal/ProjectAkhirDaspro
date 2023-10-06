/**
 * ProjekAkhir 
 * Group Member : 1. Bayu 
 *                2. Hammam 
 *                3. Ridho
 */

//import
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
//import end

public class ProjekAkhir {
    public static void main(String[] args) {
        //var 
        Scanner input = new Scanner(System.in);
        boolean inputBalance;
        String name, address, job, ml = "Mr. ", fm = "Ms. ", cName; 
        int loanTerm, menu, approval, back, gender, age, month;
        double interest = 0.005, remainingBalance, monthlyInterest, monthlyInstallments, loanAmount, remainingdebt, totalDebttobePaid, remainingInstallments;
        //format Rp
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        //format Rp end
        //var end

        //title
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗\r\n" + //
                           "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝\r\n" + //
                           "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  \r\n" + //
                           "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  \r\n" + //
                           "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗\r\n" + //
                           " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝\r\n" + //
                "                                                              \n");
        //title end

        //register
        System.out.println("----- PLEASE REGISTER FIRST -----\n");
        System.out.print("Enter full name: ");
        name = input.nextLine();
        System.out.print("Gender (Male 1,Female 0): ");
        gender = input.nextInt();
        
        if (gender == 1) {
            cName = ml+name;
        }else{
            cName = fm+name;
        }

        System.out.print("Age: ");
        age = input.nextInt();
        System.out.print("Enter your job: ");
        job = input.next();
        System.out.print("Address: ");
        address = input.next();
        System.out.println("\n-- REGISTRATION SUCCESSFUL --\n");
        //register end

        //menu
        System.out.println("----- PLEASE CHOOSE MENU: -----");
        System.out.println("|\n|    1. Balance\n|    2. Loan application\n|    3. Loan repayment\n|\n-------------------------------");
        System.out.print("-- Choose the number: ");
        menu = input.nextInt();

        //selection menu 
        switch (menu) {
            case 1:
                System.out.println("\n-- BALANCE --\n");
                System.out.print("Do you want to enter the balance? (true/false): ");
                inputBalance = input.nextBoolean();
                System.out.print("The balance amount you want to input (fill in 0 if you choose not to enter the balance or choose 0): Rp.");
                remainingBalance = input.nextDouble();
                System.out.println(cName + " your balance entry request has been submitted");
                System.out.println(" - THANK YOU -\n");
            //case 1 end

        System.out.println("----- PLEASE CHOOSE MENU: -----");
        System.out.println("|\n|    1. Balance\n|    2. Loan application\n|    3. Loan repayment\n|\n-------------------------------");
        System.out.print("-- Choose the number: ");
        menu = input.nextInt();
        
        switch (menu) {
            case 2:
                System.out.println("\n-- LOAN APPLICATION --\n");
                System.out.print("How much loan amount you want: Rp.");
                loanAmount = input.nextDouble();
                System.out.print("How long is your proposed payback period (months): ");
                loanTerm = input.nextInt();
                System.out.print("Are you willing to bear the cost of repaying the loan at 5% interest per year? (1/0): ");
                approval = input.nextInt();
                if (approval == 1) {
                    System.out.println("\n# LOAN REQUEST APPROVED #\n");
                }

                //calculation
                if (inputBalance == false) {
                    remainingBalance = 0;
                }
                remainingdebt = loanAmount - remainingBalance;
                monthlyInterest = loanTerm * interest * remainingdebt;
                System.out.println("\n-- Dear "+cName);
                String y = kursIndonesia.format(monthlyInterest);
                System.out.println("Your interest per month: "+y);
                totalDebttobePaid = monthlyInterest + remainingdebt;
                monthlyInstallments = totalDebttobePaid / loanTerm;
                String x = kursIndonesia.format(monthlyInstallments);
                System.out.println("The bill you have to pay per month amounts to: "+x);
                System.out.println(" - THANK YOU -\n");
                //calculation end
            //case 2 end

            System.out.println("----- PLEASE CHOOSE MENU: -----");
            System.out.println("|\n|    1. Balance\n|    2. Loan application\n|    3. Loan repayment\n|\n-------------------------------");
            System.out.print("-- Choose the number: ");
            menu = input.nextInt();

        switch (menu) {
            case 3:
                String a = kursIndonesia.format(totalDebttobePaid);
                String b = kursIndonesia.format(monthlyInstallments);
            
                System.out.println("\n-- LOAN REPAYMENT --\n");
                System.out.println("Dear "+cName);
                System.out.println("The loan amount you have to pay is: "+a);
                System.out.println("The loan amount you are required to pay monthly is: "+b);
                System.out.println("\n# If you want to repay the loan, you will have to pay the monthly installments set when you applied for the loan #");
                System.out.print("How many months do you want to pay monthly installments: ");
                month = input.nextInt();
                //calculation 
                remainingInstallments = totalDebttobePaid - (monthlyInstallments * month);
                //calculation end
            
                String c = kursIndonesia.format(remainingInstallments);
            
                System.out.println("    # Your installment payment has been received #");
                System.out.println(cName +" The remaining loan that you have to pay now is: "+c);
                System.out.println("-- THANK YOU FOR PAYING THE INSTALLMENT --\n");
            //case 3 end
        //menu end
        //dadfafa

        }
        }
        }
    }
}