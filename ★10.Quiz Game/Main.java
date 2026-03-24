import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        System.out.println("**************************************");
        System.out.println(   "Welcome to the Java Quiz Game!!!");
        System.out.println("**************************************");

        System.out.println("Good luck!");

        System.out.println("**************************************");

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int guess;
        boolean isPlaying = true;
            String[] questions = {
                "What is the capital of France?",
                "What is 2 * 2?",
                "What is the capital of Spain?",
                "What is the largest ocean on Earth?",
                "What is the smallest planet in our solar system?",
                "Who invented Alternating Current?"
            };

            String[][] options = {
                {"i.Paris", "ii.England", "iii.Tokyo", "iv.Berlin"}, 
                {"i.3", "ii.4", "iii.5", "iv.6"},
                {"i.Madrid", "ii.Barcelona", "iii.Sevilla", "iv.Valencia"},
                {"i.Atlantic Ocean", "ii.Indian Ocean", "iii.Pacific Ocean", "iv.Arctic Ocean"},
                {"i.Mercury", "ii.Venus", "iii.Earth", "iv.Mars"},
                {"i.Nikola Tesla", "ii.Thomas Edison", "iii.Albert Einstein", "iv.Galileo Galilei"}
            };

            int[] answers = {1, 2, 1, 3, 1, 1};

        while(isPlaying){
        for(int i=0; i<questions.length; i++){
            System.out.println(questions[i]); //<---display questions
            for(String option:options[i]){ //<---display answers
                System.out.println(option);
            }
            System.out.print("Enter your answer (1-4): "); //<---get the user's answer
            guess = scanner.nextInt();
            if(guess == answers[i]){ //<--check if the answer is correct or not(if our guess is for eg; Paris for the first questions, this condition will check if its == to the element at index 0 of answers)
                System.out.println("Correct!");
                score++;
            }else{
                System.out.println("Wrong! The correct answer was: " + options[i][answers[i]-1]);
            }
            System.out.println();
        }
        System.out.println("Your final score is: " + score + " out of " + questions.length);
        System.out.println("Do you want to play again? (y/n): ");
        String playAgain = scanner.next();
        if(playAgain.equalsIgnoreCase("y")){
            isPlaying = true;
        }else{
            isPlaying = false;
        }
    }
        scanner.close();
    }
}