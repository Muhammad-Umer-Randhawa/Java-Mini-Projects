import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
// import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("words.txt")){
            writer.write("""
                apple
                banana
                cherry
                date
                pineapple
            """);
        } 
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Couldn't write to file");
        }
        catch (Exception e) {
            System.out.println("An unexpected error occurred");
        }

        ArrayList<String> words = new ArrayList<>();
        // try{
        //     File file = new File("words.txt");
        //     Scanner scanner = new Scanner(file);
        //     while(scanner.hasNextLine()){
        //         words.add(scanner.nextLine().trim());
        //     }
        //     scanner.close();
        // }
        String filePath = "words.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Couldn't read from file");
        }

        Random random = new Random();
        byte randomIndex = (byte) random.nextInt(words.size());
        String selectedWord = words.get(randomIndex);
        
        //-------------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> guessedLetters = new ArrayList<>();
        int wrongGuesses = 0;
        for(int i = 0; i < selectedWord.length(); i++){
            guessedLetters.add('_');
        }

        while(wrongGuesses < 8 && guessedLetters.contains('_')) {
            System.out.print(HangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for(char c : guessedLetters) {
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.print("Enter your Guess: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            if(selectedWord.indexOf(guess) >= 0){
                System.out.println("Correct!\n");
                for(int i = 0 ; i < selectedWord.length(); i++){
                    if(selectedWord.charAt(i) == guess){
                        guessedLetters.set(i, guess);
                    }
                }
            }
            else{
                wrongGuesses++;
                System.out.println("Wrong guess\n");
            }
        }
        System.out.print(HangmanArt(wrongGuesses));

        System.out.print("Word: ");
        for (char c : guessedLetters) {
            System.out.print(c + " ");
        }
        System.out.println();

        if (!guessedLetters.contains('_')) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost! The word was: " + selectedWord);
        }
        scanner.close();
    }
    static String HangmanArt(int wrongGuesses){
        return switch (wrongGuesses) {
            case 0 -> """
                    """;
            case 1 -> """
                    ------
                    |    |
                    |    O
                    |   
                    |   
                    |  
                    """;
            case 2 -> """
                    ------
                    |    |
                    |    O
                    |    |
                    |
                    |
                    """;
            case 3 -> """
                    ------
                    |    |
                    |    O
                    |   /|
                    |
                    |
                    """;
            case 4 -> """
                    ------
                    |    |
                    |    O
                    |   /|\\
                    |
                    |
                    """;
            case 5 -> """
                    ------
                    |    |
                    |    O
                    |   /|\\
                    |    |
                    |
                    """;
            case 6 -> """
                    ------
                    |    |
                    |    O
                    |   /|\\
                    |    |
                    |   / 
                    |
                    """;
            case 7 -> """
                    ------
                    |    |
                    |    O
                    |   /|\\
                    |    |
                    |   / \\
                    |
                    """;
            default -> "";
        };
    }
}