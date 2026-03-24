import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        int numofDice;
        int total = 0;
        int roll = 0;
        String choice;

        while(running) {
            System.out.print("Enter the no. of dice to roll: ");
            numofDice = scanner.nextInt();

    if(numofDice > 0){
        total = 0;
        for(int i = 1; i <= numofDice; i++){
            roll = random.nextInt(1, 7);
            printDie(roll);
            System.out.println("You rolled a " + roll);
            total += roll;
        }
        System.out.println("Total: " + total);
    }
    else{
        System.out.println("No. of dice must be greater than zero!");
    }
    
    System.out.print("Do it again (y/n): ");
    choice = scanner.next();
    if (choice.equalsIgnoreCase("n")) {
        running = false;
    }
    else if(choice.equalsIgnoreCase("y")){
        running  = true;
    }
}
    scanner.close();
} 
static void printDie(int roll){
        String dice1 = """
                         -------
                        |       |
                        |   *   |
                        |       |
                         -------
                """;
        
         String dice2 = """
                         -------
                        |*      |
                        |       |
                        |      *|
                         -------
                """;
        
         String dice3 = """
                         -------
                        |*      |
                        |   *   |
                        |      *|
                         -------
                """;

         String dice4 = """
                         -------
                        |*     *|
                        |       |
                        |*     *|
                         -------
                """;

         String dice5 = """
                         -------
                        |*     *|
                        |   *   |
                        |*     *|
                         -------
                """;

         String dice6 = """
                         -------
                        |*  *  *|
                        |*  *  *|
                        |*  *  *|
                         -------
                """;
        switch(roll){
            case 1 -> System.out.print(dice1);
            case 2 -> System.out.print(dice2);
            case 3 -> System.out.print(dice3);
            case 4 -> System.out.print(dice4);
            case 5 -> System.out.print(dice5);
            case 6 -> System.out.print(dice6);
            default -> System.out.print("Invalid die roll");
        }
    }
}