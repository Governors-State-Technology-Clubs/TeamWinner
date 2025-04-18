import java.util.Scanner;

public class mainArcade {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice ;

    System.out.println("Welcome to the Arcade!");
    System.out.println("Enters from 1 to 6 to play the game");

    System.out.println("1. Guess the Number");
    System.out.println("2. Minefield");
    System.out.println("3. Hangman");
    System.out.println("4. Rock Paper Scissors");
    System.out.println("5. ??");
    System.out.println("6. ??");
    System.out.print("Enter your choice: ");

    choice = scanner.nextInt();

    switch (choice) {
        case 1:
            
            break;
        case 2:

            break;

        case 3:

            break;

        case 4:

            break;

        case 5:

            break;

        case 6:

            break;

        default:
            System.out.println("Invalid choice.");
            break;
    
    }
    scanner.close();
    }
}