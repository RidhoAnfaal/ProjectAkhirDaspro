import java.util.Scanner;
public class pemilihan2percobaan312 {
    public static void main(String[] args){
    Scanner input18 = new Scanner (System.in);
    String category;
     int income,netsalary;
     double tax = 0;
     System.out.println("input category = ");
     category = input18.nextLine();
     System.out.println("Input income = ");
     income = input18.nextInt();

     if (category.equalsIgnoreCase("worker")) {
        if(income <= 2000000)
            tax = 0.1;
        else if (income <= 3000000)
            tax = 0.15;
        else
            tax = 0.2;
         netsalary = (int)( income - (tax*income));
        System.out.println(" net salary = "+ netsalary);
    } else if (category.equals("businessman")){
        if (income <= 2500000)
            tax = 0.15;
    else if (income <= 3500000)
        tax = 0.2;
    else
        tax = 0.25;
        netsalary =(int) (income - (tax * income));
        System.out.println("net salary" + netsalary);
    } else 
    System.out.println("invalid category");
    
    }
}