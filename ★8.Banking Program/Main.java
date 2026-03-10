import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        double amount;

        System.out.println("Welcome to the Banking Program!");

        boolean running = true;
        while(running){
        System.out.println("What do you want to do?");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");

        switch(scanner.nextInt()){
            case 1:
                //deposit()
                System.out.print("Enter amount to deposit: ");
                amount = scanner.nextDouble();
                balance = deposit(balance, amount);
                System.out.println("Deposited: " + amount);
                break;
            case 2:
                //withdraw()
                System.out.print("Enter amount to withdraw: ");
                amount = scanner.nextDouble();
                balance = withdraw(balance, amount);
                System.out.println("Withdrew: " + amount);
                break;
            case 3:
                //checkBalance()
                System.out.println("Current balance: " + checkBalance(balance));
                break;
            case 4:
                // Exit
                System.out.println("Exiting...");
                running = false;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
        scanner.close();
    }
    static double deposit(double balance, double amount){
        return balance += amount;
    }
    static double withdraw(double balance, double amount){
        return balance -= amount;
    }
    static double checkBalance(double balance){
        return balance;
    }
}