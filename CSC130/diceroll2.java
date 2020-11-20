import java.util.Scanner;

public class diceGame {

    public static void main(String[] args)
    {
        String YorN = "Y";

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Dice game");

        int ranVal = (int) (Math.random() * 6) + 1;
        System.out.println("The point to match is " + ranVal); // "your" random value has been created

        int computerValue = 7; // choosing number that's not on the die
        int counter = 1; // keep track of computer attempts to match your point
        while (computerValue != ranVal)
        {
            //where is the code??? 
            //why is it outside of the loop?
        }
        computerValue = (int) (Math.random() * 6) + 1;
        System.out.println("roll " + counter + "is a" + computerValue++);

        if (computerValue == ranVal)
        {
            System.out.println("It took the computer " + counter + "tries to reach the point");

            System.out.println("Would you like to continue?");
            YorN = scan.nextLine();

            if (YorN.contentEquals("Y"))
                ;
            {
                PLAY = true;
            }
            if (YorN.contentEquals("N"))
                ;
            {
                PLAY = false;
            }

        }
        while (PLAY = true)
            ;

    }
}