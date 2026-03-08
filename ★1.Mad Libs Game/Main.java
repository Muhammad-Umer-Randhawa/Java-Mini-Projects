import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
        System.out.println("Welcome to the Mad Libs Game!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an adjective: ");
        String adjective1 = scanner.nextLine();

        System.out.print("Enter another adjective: ");
        String adjective2 = scanner.nextLine();

        System.out.print("Enter a noun: ");
        String noun1 = scanner.nextLine();

        System.out.print("Enter a verb: ");
        String verb1 = scanner.nextLine();

        System.out.println("Here's your story:");
        System.out.println("Once upon a time, there was a " + adjective1 + " " + noun1 + " who loved to " + verb1 + ". It was a " + adjective2 + " day.");

        scanner.close();
    }
}