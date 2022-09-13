import java.util.*;
public class SavingAccounts {
    int balance;
    String currency;
    public SavingAccounts(int initialBalance, String chosenCurrency) {
        balance = initialBalance;
        currency = chosenCurrency;
    }
    public void checkBalance() {
        System.out.println("Your current balance is : " + balance);
    }
    public void deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        System.out.println("Your amount to deposit is " + amountToDeposit + " " + currency + ".");
    }
    public void withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        System.out.println("Your amount to withdraw is " + amountToWithdraw + " " + currency + ".");
    }
    public String toString() {
        return "You have " + balance + " " + currency + " in your account.";
    }
    public static void main(String[] args) {
        boolean stayInLoop = true;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your initial balance : ");
            int initBalance = scan.nextInt();
            System.out.println("Choose your currency : ");
            String desiredCurrency = scan.next();
            SavingAccounts myAccount = new SavingAccounts(initBalance, desiredCurrency);
            System.out.println(myAccount);
            while(stayInLoop) {
                System.out.println("Do you want to deposit or to withdraw money?");
                String depositOrWithdraw = scan.next();
                if(depositOrWithdraw.equals("Withdraw")) {
                    System.out.println("How much money do you want to withdraw?");
                    int amountForWithdraw = scan.nextInt();
                    myAccount.withdraw(amountForWithdraw);
                } else if(depositOrWithdraw.equals("Deposit")) {
                    System.out.println("How much money do you want to deposit?");
                    int amountForDeposit = scan.nextInt();
                    myAccount.deposit(amountForDeposit);
                }
                System.out.println("Do you want another operation?");
                String yesOrNo = scan.next();
                if(yesOrNo.equals("No")) {
                    System.out.println("Ok. See you next time. Have a nice day!");
                    stayInLoop = false;
                } else if(yesOrNo.equals("Balance")) {
                    System.out.println(myAccount);
                    System.out.println("Do you want another operation?");
                    yesOrNo = scan.next();
                    if(yesOrNo.equals("No")) {
                        System.out.println("Ok. See you next time. Have a nice day!");
                        stayInLoop = false;
                    }
                }
            }
        }
    }
}