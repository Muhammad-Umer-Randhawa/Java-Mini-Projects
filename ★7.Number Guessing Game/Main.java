import java.util.Random;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(min, max+1);
        int userGuess = 0;
        int attempts = 0;
        while (userGuess != randomNumber) {
            System.out.print("Enter your guess (1-100): ");
            userGuess = scanner.nextInt();
            attempts++;
            if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }
        scanner.close();
    }
}