import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double Temp, newTemp;
        String choice;

        System.out.print("Enter temperature: ");
        Temp = scanner.nextDouble();

        System.out.print("Convert to Celsius or Fahrenheit (C/F)? : ");
        choice = scanner.next().toUpperCase();

        newTemp = (choice.equals("C")) ? (Temp - 32) * 5/9 : (Temp * 9/5) + 32;

        System.out.printf("Converted temperature: %.2f°%s", newTemp, choice);
        scanner.close();
    }
}