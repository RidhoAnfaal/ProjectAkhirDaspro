/**
 * ProjekAkhir 
 * Group Member : 1. Bayu 
 *                2. Hammam 
 *                3. Ridho
 */
import java.util.Scanner;
public class ProjekAkhir {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //var
        String name, address; 
        int loanTerm, menu, approval, back;
        double interest = 0.005, remainingBalance, monthlyInterest, monthlyInstallments, loanAmount, remainingdebt, totalDebttobePaid;
        //var end

        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗\r\n" + //
                           "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝\r\n" + //
                           "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  \r\n" + //
                           "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  \r\n" + //
                           "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗\r\n" + //
                           " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝\r\n" + //
                "                                                              \n");
        
        //register
        System.out.println("----- PLEASE REGISTER FIRST -----\n");
        System.out.print("Enter full name: ");
        name = input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();
        System.out.println("\n-- SUCCESSFUL REGISTRATION --\n");
        //register end

        //menu
        System.out.println("----- PLEASE CHOOSE MENU: -----");
        System.out.println("|\n|    1. Balance\n|    2. Loan application\n|    3. Loan repayment\n|\n-------------------------------");
        System.out.print("-- Choose the number: ");
        menu = input.nextInt();

        //selection menu 
        if (menu + 0 == 1) {
            System.out.println("\n-- BALANCE --\n");
            System.out.print("The balance amount you want to input: Rp.");
            remainingBalance = input.nextDouble();
            System.out.println(name + " your balance entry request has been submitted");
            System.out.println(" - THANK YOU -\n");

        System.out.println("----- PLEASE CHOOSE MENU: -----");
        System.out.println("|\n|    1. Balance\n|    2. Loan application\n|    3. Loan repayment\n|\n-------------------------------");
        System.out.print("-- Choose the number: ");
        menu = input.nextInt();

        if (menu + 0 == 2) {
            System.out.println("\n-- LOAN APPLICATION --\n");
            System.out.print("How much loan amount you want: Rp.");
            loanAmount = input.nextDouble();
            System.out.print("How long is your proposed payback period (months): ");
            loanTerm = input.nextInt();
            System.out.print("Are you willing to bear the cost of repaying the loan at 5% interest per year? (1/0): ");
            approval = input.nextInt();
            if (approval + 0 == 1) {
                System.out.println("- LOAN REQUEST APPROVED -");
            }

            //calculation
            remainingdebt = loanAmount - remainingBalance;
            if (remainingBalance * 1 == 0) {
                remainingdebt = loanAmount;
                monthlyInterest = loanTerm * interest * remainingdebt;
                System.out.println("Your interest per month: Rp."+monthlyInterest);
                totalDebttobePaid = remainingdebt + monthlyInterest;
                monthlyInstallments = totalDebttobePaid / loanTerm;
                System.out.println("The bill you have to pay per month amounts to: Rp."+ monthlyInstallments);
                
            }
            monthlyInterest = loanTerm * interest * remainingdebt;
            System.out.println("Your interest per month: Rp."+monthlyInterest);
            totalDebttobePaid = remainingdebt + monthlyInterest;
            monthlyInstallments = totalDebttobePaid / loanTerm;
            System.out.println("The bill you have to pay per month amounts to: Rp."+ monthlyInstallments);

        System.out.println("----- PLEASE CHOOSE MENU: -----");
        System.out.println("|\n|    1. Balance\n|    2. Loan application\n|    3. Loan repayment\n|\n-------------------------------");
        System.out.print("-- Choose the number: ");
        menu = input.nextInt();

        if (menu + 0 == 3) {
            System.out.println("\n-- LOAN REPAYMENT --\n");
            
        }
        }    
        }

      



    }
}
