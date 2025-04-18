package Classes;
import java.util.*;

public class WordScramble {
    public static void main(Scanner input) {
        Random random = new Random();
        int attempts = 0;
        boolean correct= false;

        String[] teams = {
            "hawks", "celtics", "nets", "hornets", "bulls",
            "cavaliers", "mavericks", "nuggets", "pistons", "warriors",
            "rockets", "pacers", "clippers", "lakers", "grizzlies",
            "heat", "bucks", "timberwolves", "pelicans", "knicks",
            "thunder", "magic", "sixers", "suns", "blazers",
            "kings", "spurs", "raptors", "jazz", "wizards"
        };
        String word = teams[random.nextInt(teams.length)];
        List<Character> letters = new ArrayList<>();
        for (char c : word.toCharArray()) letters.add(c);
        Collections.shuffle(letters);

        StringBuilder scrambled = new StringBuilder();
        for (char c : letters) scrambled.append(c);

        System.out.println("Welcome to Word Scramble !");
        System.out.println("This game is based off NBA teams!");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Unscramble this team: "+ scrambled);

        while (attempts < 3 && !correct ){
            System.out.println("Your guess (" + (3 - attempts) +" left)");
            String guess = input.nextLine();

            if (guess.equalsIgnoreCase(word)){
            System.out.print("Congrats You've won!");
            correct = true;
            }
            else{
                System.out.print("Nope guess again!");
                attempts ++;

            }



        }
        if (!correct){
            System.out.print("Out of attempts! The Team was "+ word);
        }

    }
  
}
