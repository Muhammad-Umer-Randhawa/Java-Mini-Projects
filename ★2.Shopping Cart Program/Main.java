import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Shopping Cart Program
        System.out.println("Welcome to the Shopping Cart Program!");
        Scanner scanner = new Scanner(System.in);
        String item;
        double price;
        int quantity;
        System.out.print("Enter item name: ");
        item = scanner.nextLine();
        System.out.print("Enter item price: ");
        price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        quantity = scanner.nextInt();
        double total = price * quantity;
        System.out.println("Total price for " + quantity + " " + item + "(s): $" + total);
        scanner.close();
    }
}
