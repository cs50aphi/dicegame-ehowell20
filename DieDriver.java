import java.util.Scanner;

public class DieDriver
{
    public static void main(String[] args)
    {
        boolean gameOver = false;
        int goal = 42;
        int location = 0;
        int max;
        int tempRoll;
        int roll1;
        int roll2;
        // Create two dice
        Die d1 = new Die();
        Die d2 = new Die();
        // While gameOver is false
        do
        {
            // report game location
            System.out.println("You are at " + location);
            pause ();
            // roll for p1
            // roll both dice
            roll1 = d1.roll();
            roll2 = d2.roll();
            // add dice numbers together
            tempRoll = roll1 + roll2;
            // report back current number
            location = nextStep(1, location, tempRoll, goal, roll1, roll2);
            if (location == goal)
            {
                // if p1 has won, game over and skip player 2 turn
                System.out.println("Player 1 wins!");
                gameOver = true;
                continue;
            }
            else if (location > goal)
            {
                // if p1 goes over goal, game over and skip player 2 turn
                System.out.println("Bust! Player 1 loses!");
                gameOver = true;
                continue;
            }
            System.out.println("You are at " + location);
            pause ();
            // roll for player 2
            // roll both dice
            roll1 = d1.roll();
            roll2 = d2.roll();
            // add dice numbers together
            tempRoll = roll1 + roll2;
            // report back current number
            location = nextStep(2, location, tempRoll, goal, roll1, roll2);
            if (location == goal)
            {
                // if p2 has won, game over and exit loop
                System.out.println("Player 2 wins!");
                gameOver = true;
            }
            else if (location > goal)
            {
                // if p2 goes over goal, game over and exit loop
                System.out.println("Bust! Player 2 loses!");
                gameOver = true;
            }

        }
        while (!gameOver);
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to if you wish to roll");
        in.nextLine();
    }
    public static int nextStep(int player, int location, int tempRoll, int goal, int roll1, int roll2)
    {
        System.out.println("Player " + player + " rolls a " + tempRoll);
        if (roll1 == roll2)
        {
            // if player rolls doubles, allow player to choose largest number to roll
            location += tempRoll;
            Scanner number = new Scanner(System.in);
            // notify player of doubles 
            System.out.println("Congrats! You rolled doubles!");
            // notify player of location
            System.out.println("You are at " + location);
            System.out.println("What is the largest number you would like to roll?");
            // create die to roll up to largest number chosen
            int max = number.nextInt();
            Die d3 = new Die();
            tempRoll = d3.roll(max);
            // notify what was rolled
            System.out.println("Player " + player + " rolls a " + tempRoll);
            // return location
            location += tempRoll;
            return location;
        }
        else
        {
            // return current location
            location += tempRoll;
            return location;
        }
    }
}