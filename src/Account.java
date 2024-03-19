import java.util.Date;

public class Account {
   protected int id;
   protected double balance;
   protected Date dateOpened;
   
   public Account() {    // default 
      this.id = 0;
      this.balance = 0;
      dateOpened = new Date();
   }
   
   public Account(int id, double balance) {
      this.id = id;
      this.balance = balance;
      dateOpened = new Date();
   }
   
   public int getId() {
      return id;
   }
   
   public double getBalance() {
      return balance;
   }
   
   public void setId(int id) {
      this.id = id;
   }
   
   public void setBalance(double balance) {
      this.balance = balance;
   }
   
   public Date getDateOpened() {
      return dateOpened;
   }
   
  public void withdraw(double amount) {
      this.balance = balance - amount;
   }
   
   public void deposit(double amount) {
      this.balance += amount;
   }
   
   public String toString() {
      return "Account ID: " + this.id + "\n" + "Account Opened: " + dateOpened + "\n" + "Balance: $" + this.balance;
   }
}