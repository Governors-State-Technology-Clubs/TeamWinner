package Classes;

import javax.lang.model.type.NullType;
import java.util.*;


public class mineSweeper {

    static private String gameState = "running"; //State of the game. "running", "gameWon", or "gameLost"

    public static void main(Scanner scanner) {

        Node[][] gameBoard = new Node[8][10];
        for(int y = 0; y < gameBoard.length; y++)
        {
            for(int x = 0; x < gameBoard[0].length; x++)
            {
                gameBoard[y][x] = new Node(x, y);
            }
        }
        placeBombs(gameBoard, 10);
        printBoard(gameBoard);
        while(gameState.equals("running"))
        {
            System.out.println("What would you like to do?");
            System.out.println("X to dig");
            System.out.println("F to flag");
            String input = scanner.nextLine();
            if(input.toLowerCase().replaceAll(" ", "").equals("x"))
            {
                System.out.println("Where would you like to dig? Ex: 3,4");
                input = scanner.nextLine();
                try {
                    int x = Integer.parseInt(input.substring(0,input.indexOf(","))) - 1;
                    int y = Integer.parseInt(input.substring(input.indexOf(",")+1)) - 1;
                    dig(gameBoard[gameBoard.length-1-y][x]);
                    printBoard(gameBoard);
                }catch(Exception e)
                {
                    System.out.println("invalid guess. Please try again with the following format: x,y");
                }




            }
            checkWin(gameBoard);

        }
        if(gameState.equals("gameWon"))
        {
            System.out.println("You win!");
            System.out.println("Sending you back to game select");
        }
        else {
            System.out.println("You lose :(");
        }

    }
    public static void checkWin(Node[][] gb)
    {
        for(int i = 0; i < gb.length; i++)
        {
            for(int j = 0; j < gb[0].length; j++)
            {
                if(!gb[j][i].isBomb() && !gb[j][i].isDug()) { return; }
            }
        }
        gameState = "gameWon";
    }
    public static void clearAway(Node[][] gb, int guessX, int guessY)
    {
        if(gb[guessX][guessY+1].getNumOfAdjacentBombs() != 0)
        {
            gb[guessX][guessY+1].setDug(true);
            return;
        }
        if(gb[guessX-1][guessY].getNumOfAdjacentBombs() != 0)
        {
            gb[guessX-1][guessY].setDug(true);
            return;
        }
        if(gb[guessX][guessY-1].getNumOfAdjacentBombs() != 0)
        {
            gb[guessX][guessY-1].setDug(true);
            return;
        }
        if(gb[guessX+1][guessY].getNumOfAdjacentBombs() != 0)
        {
            gb[guessX+1][guessY].setDug(true);
            return;
        }

    }

    public static void dig(Node node)
    {
        if(node.isBomb())
        {
            gameState = "gameLost";

        }
        else if(node.isFlag())
        {
            System.out.println("This is flagged.");
        }
        else if(node.isDug())
        {
            System.out.println("This has already been dug.");
        }
        else
        {
            node.setDug(true);
        }
    }

    public static void placeBombs(Node[][] gb, int b) //b = numb of bombs
    {
        Random rand = new Random();
        System.out.println(rand);
        
        int count = 0;
        while(count < b)
        {
            int y = rand.nextInt(gb.length);
            int x = rand.nextInt(gb[0].length);
            
            if (!gb[y][x].isBomb()) {
                gb[y][x].setBomb(true);
                count++;
                for(int i = y-1; i < y+2; i++)
                {
                    for(int j = x-1; j < x+2; j++)
                    {
                        try{
                            gb[i][j].setNumOfAdjacentBombs(gb[i][j].getNumOfAdjacentBombs() + 1);
                        } catch(ArrayIndexOutOfBoundsException e){ }
                    }
                }


            }
        }
    }

//method to print game board

    public static void printBoard(Node[][] gb)
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
                if(gb[i][j].isBomb())
                {
                    System.out.print(" "+ "B" +" |");
                }
                else if(gb[i][j].isFlag())
                {
                    System.out.print(" "+ "F" +" |");
                } else if (gb[i][j].isDug())
                {
                    System.out.print(" "+ gb[i][j].getNumOfAdjacentBombs() +" |");
                } else
                {
                    System.out.print(" "+ " " +" |");
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

class Node
{
//-------Class Variables
    private int xPos;
    private int yPos;
    private int numOfAdjacentBombs;
    private boolean isBomb;
    private boolean isFlag;
    private boolean isDug;

    //-----Constructor
    public Node(int x, int y)
    {
        xPos = x;
        yPos = y;
        isBomb = false;
        isFlag = false;
        isDug = false;
    }

    //-----Accessor Methods
    public int getXPos(){ return xPos; }
    public int getYPos(){ return yPos; }
    public int getNumOfAdjacentBombs(){ return numOfAdjacentBombs; }
    public boolean isBomb(){ return isBomb; }
    public boolean isFlag(){ return isFlag; }
    public boolean isDug(){return isDug;}


    //-----Mutator Methods
    public void setBomb(boolean a) { isBomb = a; }
    public void setDug(boolean a){ isDug = a;}
    public void setNumOfAdjacentBombs(int n) {numOfAdjacentBombs = n;}


}
