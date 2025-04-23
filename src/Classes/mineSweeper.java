package Classes;

import java.util.*;


public class mineSweeper {

    public static void main(Scanner scanner) {
        String[][] gameBoard = {   // y, x
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
        };
        gameBoard = placeBombs(gameBoard, 10);
        printBoard(gameBoard);
        System.out.println("Hello World");
    }

    public static String[][] placeBombs(String[][] gb, int b) //b = numb of bombs
    {
        Random rand = new Random();
        System.out.println(rand);
        
        int count = 0;
        while(count < b)
        {
            int r = rand.nextInt(gb.length);
            int c = rand.nextInt(gb[0].length);
            
            if (gb[r][c].equals(" ")) {
                gb[r][c] = "X";
                count++;
            }
        }
        return gb;
    }
//method to print game board
    public static void printBoard(String[][] gb)
    {
        System.out.print("+");
        for(int i = 0; i < gb[0].length; i++)
        {
            System.out.print("---+");
        }
        System.out.println();
        for(int i = 0; i < gb.length; i++)
        {
            System.out.print("|");
            for(int j = 0; j < gb[0].length; j++)
            {
                
                    System.out.print(" "+ gb[i][j] +" |");
                
                
            }
        System.out.println();    
        System.out.print("+");
        for(int t = 0; t < gb[0].length; t++)
        {
            System.out.print("---+");
        }
        System.out.println();
        }
    }
}
/* 
class Node
{

    int xPos;
    int yPos;
    boolean isBomb;
    boolean isFlag;
    Node()
    {

    }


}
*/