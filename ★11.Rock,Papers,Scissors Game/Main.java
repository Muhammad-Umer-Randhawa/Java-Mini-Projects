import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String userChoice;
        String computerChoice;
        boolean isPlaying = true; 

        String[] options = {"rock", "paper", "scissors"};

        while (isPlaying) {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            userChoice = scanner.nextLine().toLowerCase();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            computerChoice = options[random.nextInt(options.length)];

            System.out.println("User choice: " + userChoice);
            System.out.println("Computer choice: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (playAgain.equals("y")) {
                isPlaying = true;
            } else {
                isPlaying = false;
            }
        }
        scanner.close();
    }
}