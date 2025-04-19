package Classes;

import java.util.*;


public class mineSweeper {
    public static void main(Scanner scanner) {
        int[][] gameBoard = {   // y, x
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        printBoard(gameBoard);
        System.out.println("Hello World");
    }


//method to print game board
    public static void printBoard(int[][] gb)
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
                
                if (gb[i][j] == 0) {
                    System.out.print("   |");  //*INSERT ACTUAL THING TO PRINT */
                }
                
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
