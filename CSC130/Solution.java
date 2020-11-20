
import java.io.*;
import java.util.*;


class Solution
{
  public static void main(String[] args) throws IOException
  {
        Scanner scan = new Scanner(System.in);
        
        // Input choice 
        System.out.println("Input:");
        System.out.println("r for Rock");
        System.out.println("s for Spock");
        System.out.println("p for Paper");
        System.out.println("l for Lizard");
        System.out.println("c for Scissors");
    
        String answer = "y";
        String humanChoice;
        int humanChoiceInt;
        String[] computerCanChoose = new String[] { "r", "s", "p", "l", "c" };


        while (answer.equals("y"))
        {
            System.out.println("Please choose r, s, p, l, or c");
            humanChoice = scan.next(); // user input

          // Choice made by the player "Human"
          humanChoiceInt = myChoice(humanChoice); //asigning integer value

          // Random number 
          int computerSelectedInt = (int)(Math.random()*4);
          System.out.println(computerSelectedInt);
          // Getting a random choice for computer
          String computerChoice = computerCanChoose[computerSelectedInt]; 

          System.out.println("Human: " + humanChoice + " Computer: " + computerChoice);

          // Testing 
          System.out.println("Computer: " + computerSelectedInt +
                             " User: " + humanChoiceInt);

          // Subtraction
          int counter = 1;
          int gameSet = humanChoiceInt - computerSelectedInt;
          if (gameSet == 0) {
              System.out.println("It's a tie!");
          }
          else if (gameSet < 0) {
            System.out.println("Human has won!");
          }
          else 
            System.out.println("Computer has won!");    

          String [][] graph = new String [5][5];
                  graph[0][1] = "Rock vaporized by Spock";
                  graph[0][2] = "Rock covered by Paper";
                  graph[0][3] = "Rock crushes Lizard"; // and so on... yup lemme fillem in
                  graph[0][4] = "Rock crushes Scissors";
                  graph[1][0] = "Spock vaporizes Rock";
                  graph[1][2] = "Spock disproved by Paper";
                  graph[1][3] = "Spock poisoned by Lizard";
                  graph[1][4] = "Spock smash Scissors";
                  graph[2][0] = "Paper covers Rock ";
                  graph[2][1] = "Paper disproves Spock";
                  graph[2][3] = "Paper eaten by Lizard";
                  graph[2][4] = "Paper cut by Scissors";
                  graph[3][0] = "Lizard crushed by Rock";
                  graph[3][1] = "Lizard poisons Spock";
                  graph[3][2] = "Lizard eats Paper";
                  graph[3][4] = "Lizard decapitated by Scissors";
                  graph[4][0] = "Scissors crushed by Rock";
                  graph[4][1] = "Scissors smashed by Spock";
                  graph[4][2] = "Scissors cut Paper";
                  graph[4][3] = "Scissors decapitates Lizard";

                  String action = graph[computerSelectedInt][humanChoiceInt];
                  System.out.println(action);
          System.out.println("Game number " + counter++);

                 //  Printing a yes or no input to continue or end the game
        System.out.println("Would you like to continue? (press y (yes) or n (no))");
        answer = scan.next();
  
      } // end of while loop
    
    scan.close();
    System.out.println("Thanks for palying");
    
   } // end of main 
      public static int myChoice(String choice)
      {
        int userInt = -1;
        // First set of switch case
           switch(choice)
           {
             case "r":
                 userInt = 0;
                 break;
             case "s":
                 userInt = 1;
                 break;
             case "p":
                 userInt = 2;
                 break;
             case "l":
                 userInt = 3;
                 break;
             case "c": 
                 userInt = 4;
                 break;
              default: 
               System.out.println("Bad Input");
           }

          return userInt; 

    }
      
// Scope is anything between two curly braces. Anything that is defined between these is include, computer
}