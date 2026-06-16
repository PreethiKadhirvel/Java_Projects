import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine ");
        int password=7890;
        int balance=1000;
        int attempts=3;
        ArrayList<String> transactions=new ArrayList<>();
        //pin verification loop
        while (attempts>0){
            System.out.print("Enter your 4-digit Pin: ");
            int pin;
            try{
                pin=sc.nextInt();
            } catch (Exception e){
                System.out.println("Invalid input! Please enter numbers only. ");
                sc.next();// clear invalid input
                continue;
            }
            if (pin==password) {
                System.out.println("Pin Accepted! ");

              while (true){
                System.out.println("ATM Menu");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Mini Statement");
                System.out.println("5. Exit");
                System.out.println();
                System.out.print("Enter your choice (1-5): ");
                int choice;
                try{
                    choice=sc.nextInt();
                } catch (Exception e){
                    System.out.println("Invalid input! Please enter a number");
                    sc.next();
                    continue;
                }
                  if (choice==1){
                      System.out.println("Your Current Balance is Rs: " + balance);
                  }
                  else if (choice==2) {
                      System.out.println("Enter amount to deposit in Rs: ");
                      int deposit=sc.nextInt();
                      if (deposit<=0){
                          System.out.println("Amount must be greater than 0. ");
                      }else {
                          balance+=deposit;
                          transactions.add("Deposited Rs" + deposit);
                          System.out.println("Deposited Rs " + deposit + ". New Balance: Rs" + balance);
                      }
                  }
                  else if (choice==3) {
                      System.out.println("Enter amount to withdraw: Rs ");
                      int withdraw=sc.nextInt();
                      if (withdraw<=0){
                          System.out.println("Amount must be greater than 0.");
                      } else {
                          balance-=withdraw;
                          transactions.add("Withdraw Rs" + withdraw);
                          System.out.println("Withdraw Rs " + withdraw + ". Remaining Balance: Rs " + balance);
                      }
                  }
                  else if (choice==4) {
                      System.out.println("\n Mini Statement: ");
                      if(transactions.isEmpty()){
                          System.out.println("No recent tranactions. ");
                      }else {
                          int start=Math.max(transactions.size()-5, 0);
                          for (int i = start; i < transactions.size(); i++) {
                              System.out.println("- " + transactions.get(i));
                          }
                      }
                      System.out.println();
                  } else if (choice==5) {
                      System.out.println("Thank you for using ATM. Please Visit Again! ");
                      break;
                  }
                  else {
                      System.out.println("Invalid choice. Please enter between 1-5.");
                  }
              }
              break;
            }
            else {
                attempts--;
                System.out.println("Incorrect PIN. "+ attempts + "Attempts(s) left. ");

                if (attempts==0){
                    System.out.println("Too many incorrect attempts. Card blocked.");
                }
            }
        }
        sc.close();
    }
}
