import java.util.Scanner;

/**
 * Write a description of class RockPaperScissors here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RockPaperScissors
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String player1 = scan.next().toLowerCase();
        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String player2 = scan.next().toLowerCase(); 
        
        if (player1.compareTo(player2) == 0){
            System.out.println("It is a tie");
        }
        else if (player1.compareTo("rock") == 0){
            if (player2.compareTo("scissors") == 0){
                System.out.println("Player 1 wins");
            }
            else/* if (player2 == "paper")*/{
                System.out.println("Player 2 wins");
            }
        }
        else if (player1.compareTo("paper") == 0){
            if (player2.compareTo("scissors") == 0){
                System.out.println("Player 2 wins");
            }
            else/* if (player2 == "rock")*/{
                System.out.println("Player 1 wins");
            }
        }
        else{
            if (player2.compareTo("paper") == 0){
                System.out.println("Player 1 wins");
            }
            else/* if (player2 == "rock")*/{
                System.out.println("Player 2 wins");
            }
        }
        
    }

}
