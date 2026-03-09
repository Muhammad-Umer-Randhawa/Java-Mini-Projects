import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double principal, rate, amount;
        int timesCompounded, years;

        System.out.print("Enter Principal amount: ");
        principal = scanner.nextDouble();

        System.out.print("Enter Rate of interest(%): ");
        rate = scanner.nextDouble() / 100;

        System.out.print("Enter Number of times compounded per year: ");
        timesCompounded = scanner.nextInt();

        System.out.print("Enter Number of Years: ");
        years = scanner.nextInt(); 

        amount = principal * Math.pow(1 + rate/timesCompounded, timesCompounded * years);

        System.out.println("Total Amount: $" + amount);
        System.out.println("Compound Interest: $" + (amount - principal));
        scanner.close();
    }
}