import java.util.Scanner;
public class RPS
{   
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); //open scanner
        String answer = "y"; // answer string set = to "y"es
        String decision = null; // in game decision
        int compVal; // computer decision

        System.out.print("Welcome to Rock, Paper, Scissors, Lizard, Spock\n");
        System.out.print("");

        //while user says "y"es
        while(answer.equals("y"))
        {
            System.out.print("Enter one of the following: r,s,c,l, or p \n:");
            decision = input.nextLine();
            
            compVal = (int) (Math.random() * 5);

            evaluate(decision, compVal);
            //Math.floormod()

            System.out.println("Would you like to keep playing? Enter 'y' to continue... ");
            answer = input.nextLine();
        }

        input.close(); //close scanner
        System.out.println("Thank you for playing:)");
    }
    
    static void evaluate(String decision, int compVal) {
        int userVal = -1; // random value assigned
        String userCharacter = null;
        String compCharacter = null;

        switch (decision) {
            case "r":
                userCharacter = "Rock";
                userVal = 0;
                break;
            case "s":
                userCharacter = "Spock";
                userVal = 1;
                break;
            case "p":
                userCharacter = "Paper";
                userVal = 2;
                break;
            case "l":
                userCharacter = "Lizard";
                userVal = 3;
                break;
            case "c":
                userCharacter = "Scissors";
                userVal = 4;
                break;
            default:
                System.out.println("Bad Input");
                return;
        }

        switch (compVal)
        {
            case 0:
                compCharacter = "Rock";
                break;
            case 1:
                compCharacter = "Spock";
                break;
            case 2:
                compCharacter = "Paper";
                break;
            case 3:
                compCharacter = "Lizard";
                break;
            case 4:
                compCharacter = "Scissors";
                break;
        }

        String [][] graph = new String [5][5];

        for(int i = 0; i < 5; i++) // for loop sets oblique column to "loves"
        {
            graph[i][i] = " loves ";
        }

        graph[0][1] = " vaporized by ";
        graph[0][2] = " covered by ";
        graph[0][3] = " crashes ";
        graph[0][4] = " crushes ";
        graph[1][0] = " vaporizes ";
        graph[1][2] = " disproved by ";
        graph[1][3] = " poisoned by ";
        graph[1][4] = " smash ";
        graph[2][0] = " covers ";
        graph[2][1] = " disproves ";
        graph[2][3] = " eaten by ";
        graph[2][4] = " cut by ";
        graph[3][0] = " crushed by";
        graph[3][1] = " poisons ";
        graph[3][2] = " eats ";
        graph[3][4] = " decapitated by ";
        graph[4][0] = " crushed by ";
        graph[4][1] = " smashed by ";
        graph[4][2] = " cut ";
        graph[4][3] = " decapitates ";

        String action = graph[compVal][userVal];

        System.out.println(compCharacter + action + userCharacter);
    }
}