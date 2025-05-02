package src;

import java.util.Scanner;
import Classes.YesNo;


public class mainArcade {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice ;
    boolean keepPlaying = true;

    while (keepPlaying){
    System.out.println("Welcome to the Arcade!");
    System.out.println("Enter numbers from 1 to 5 to play the game");

    System.out.println("1. Guess the Number");
    System.out.println("2. Solitaire ");
    System.out.println("3. Yes Or No?");
    System.out.println("4. Word Scramble");
    System.out.println("5. Mine Sweeper");
    System.out.print("Enter your choice: ");

    choice = scanner.nextInt();
    scanner.nextLine();


    switch (choice) {
        case 1:
            Classes.RandomNumberGenerator.main(null);
            break;
        case 2:

            break;

        case 3:
            Classes.YesNo.main(null);

            break;

        case 4:
            Classes.WordScramble.main(scanner);

            break;

        case 5:
            Classes.mineSweeper.main(scanner);
            break;

        default:
            System.out.println("Invalid choice.");
            break;
    
    }
    if (keepPlaying)  {
        System.out.println("\nDo you want to return to arcade ?\n(1 for yes / 2 for no) ");
        int again = scanner.nextInt();
        scanner.nextLine();
        if (again == 2){
            keepPlaying = false;
            System.out.println("Thanks for playing!");

        }
    }
}
    
    }
}