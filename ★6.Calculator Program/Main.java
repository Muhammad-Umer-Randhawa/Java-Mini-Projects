import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int a, b;
        char operator;

        System.out.print("Enter First Number: ");
        a = scanner.nextInt();
        System.out.print("Enter Second Number: ");
        b = scanner.nextInt();
        System.out.print("Enter Operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        switch(operator){
            case '+' -> System.out.println("Result: " + (a + b));
            case '-' -> System.out.println("Result: " + (a - b));
            case '*' -> System.out.println("Result: " + (a * b));
            case '/' -> {
                if (b != 0) {
                    System.out.println("Result: " + (a / b));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
            }
            default -> System.out.println("Error: Invalid operator.");
        }
        scanner.close();
    }
}