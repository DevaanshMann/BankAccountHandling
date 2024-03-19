import java.util.ArrayList;
import java.util.Scanner;

public class lab19 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num = 0;
      double amount = 0;
      
      ArrayList<Checking> newChecking = new ArrayList<>();
      ArrayList<Savings> newSavings = new ArrayList<>();

      while (num >= 0) {
         System.out.println("********************************\n");
         System.out.println("Select an option:\n" + "1) Open a checking account\n" +
            "2) Checking Deposit\n" + "3) Checking Withdraw\n" + "4) Print checking account info\n" +
            "5) Open a savings account\n" + "6) Savings Deposit\n" + "7) Savings Withdraw\n" +
            "8) Print monthly interest\n" + "9) Print savings account info\n" + "10) Exit");
         num = sc.nextInt();
         System.out.println("\n********************************\n");
         
         if (num >= 10)
            num = -1;
            
         if (num == 1) {
            //Open a checking account
            int newId = newChecking.size() + 1000;
            System.out.print("Enter initial balance for Account #" + newId + ": $");
            double balance = sc.nextDouble();
            
            Checking check = new Checking(newId, balance);
            newChecking.add(check);
            
            System.out.println("\n" + newChecking.get(newChecking.size()-1));
         }
         
         if (num == 2) {
            //Checking Deposit
            int index = checkCheckingId(newChecking);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               System.out.print("Enter deposit amount: $");
               amount = sc.nextDouble();
               newChecking.get(index).deposit(amount);
               
               System.out.println();
               System.out.println(newChecking.get(index));
            }
         }
         
         if (num == 3) {
            //Checking Withdraw
            int index = checkCheckingId(newChecking);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               System.out.print("Enter withdrawal amount: $");
               amount = sc.nextDouble();
               newChecking.get(index).withdraw(amount);
               
               System.out.println();
               System.out.println(newChecking.get(index).toString());
            }
         }
         
         if (num == 4) {
            //Print checking
            int index = checkCheckingId(newChecking);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               System.out.println(newChecking.get(index).toString());
            }
         }
         
         if (num == 5) {
            //Open a savings account
            int newId = newSavings.size() + 1000;
            System.out.print("Enter initial balance for Account #" + newId + ": $");
            double balance = sc.nextDouble();
            System.out.print("Enter annual interest rate: ");
            double rate = sc.nextDouble();
            
            Savings save = new Savings(newId, balance, rate);
            newSavings.add(save);
            
            System.out.println("\n" + newSavings.get(newSavings.size()-1));
         }
         
         if (num == 6) {
            //Savings Deposit
            int index = checkSavingsId(newSavings);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               System.out.print("Enter deposit amount: $");
               amount = sc.nextDouble();
               newSavings.get(index).deposit(amount);
               
               System.out.println();
               System.out.println(newSavings.get(index));
            }

         }
         
         if (num == 7) {
            //Savings Withdraw
            int index = checkSavingsId(newSavings);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               System.out.print("Enter withdrawal amount: $");
               amount = sc.nextDouble();
               newSavings.get(index).withdraw(amount);
               
               System.out.println();
               System.out.println(newSavings.get(index).toString());
            }
         }
         
         if (num == 8) {
            //Print monthly interest
            int index = checkSavingsId(newSavings);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               double interest = newSavings.get(index).getMonthlyInterest()*newSavings.get(index).getBalance();
               int ID = (int) newSavings.get(index).getId();
               
               System.out.print("Account " + ID + " has earned: $");
               System.out.printf("%.2f\n", interest);
               System.out.println();
            }
         }
         
         if (num == 9) {
            //Print savings
            int index = checkSavingsId(newSavings);
            if (index < 0)
               System.out.println("Account nonexistent.");
            else {
               System.out.println();
               System.out.println(newSavings.get(index).toString());
            }
         }
      }
      
      System.out.println("Thank you!\n");
   }

//My Methods

public void clearScreen(){
   System.out.print("\033[H\033[2J");
   // System.out.flush();
}
 
   public static int checkCheckingId(ArrayList<Checking> newCheck) {
      Scanner sc = new Scanner(System.in);
   
      System.out.print("Enter Account ID: ");
      int id = sc.nextInt();
   
      for (int i = 0; i <= newCheck.size() - 1; i++) {
         if (newCheck.get(i).getId() == id)
            return i;
      }
         return -1;
   }
   
   public static int checkSavingsId(ArrayList<Savings> newSave) {
      Scanner sc = new Scanner(System.in);
   
      System.out.print("Enter Account ID: ");
      int id = sc.nextInt();
   
      for (int i = 0; i <= newSave.size() - 1; i++) {
         if (newSave.get(i).getId() == id)
            return i;
      }
         return -1;
   }
}
