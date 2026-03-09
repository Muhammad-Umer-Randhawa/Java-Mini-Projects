import java.util.Scanner;
public class Main{
    public static void main(String[] args) {

        //Weight conversion program:

        Scanner scanner = new Scanner(System.in);
        int choice;
        double lbs;
        double kgs;

        System.out.println("Press 1 to convert lbs to kgs and 2 to convert kgs to lbs:");

        choice = scanner.nextInt();

        if(choice == 1){
            System.out.print("Enter weight in lbs: ");
            lbs = scanner.nextDouble();
            kgs = lbs * 0.453592;
            System.out.printf("Weight in kgs: %.2f kgs%n", kgs);
        }

        else if (choice == 2) {
            System.out.print("Enter weight in kgs: ");
            kgs = scanner.nextDouble();
            lbs = kgs / 0.453592;
            System.out.printf("Weight in lbs: %.2f lbs%n", lbs);
        }

        else{
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}