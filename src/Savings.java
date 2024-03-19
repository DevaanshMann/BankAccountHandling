//savings account uml

public class Savings extends Account {
   protected double annualInterestRate;
   
   public Savings() {
   }
   
   public Savings(int id, double balance, double rate) {
      this.id = id;
      this.balance = balance;
      this.annualInterestRate = rate;
   }
   
   public void setAnnualInterest(double rate) {
      this.annualInterestRate = rate;
   }
   
   public double getAnnualInterest() {
      return this.annualInterestRate;
   }
   
   public double getMonthlyInterest() {
      return annualInterestRate / 1200;
   }
   
   public void withdraw(double amount) {
      if ((this.balance-amount) < 0) {
         System.out.println("Error: Insufficient Balance");
      }
      else {
         this.balance -= amount;
      }
   }
    
   public String toString() {
      return "Savings\n" + super.toString() + "\n" + "Interest Rate: " + annualInterestRate + "%";
   }
}

