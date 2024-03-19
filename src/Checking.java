//checkings account uml

public class Checking extends Account {
   protected double overdraftlimit = -500;
   
   public Checking() {
   }
   
   public Checking(int id, double balance) {
      this.id = id;
      this.balance = balance;
   }
   
   public void withdraw(double amount) {
      if ((this.balance-amount) < overdraftlimit) {
         System.out.println("Error: Overdraft Limit Reached.");
      }
      else {
         this.balance = balance - amount;
      }
   }
   
   public String toString() {
      return "Checkings\n" + super.toString();
   }
}