package randomNumbersPractice;


public class diceRoll{
    public static void main(String[] args) throws Exception {

    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to the Dice game");
    
    String answer = "y";

    while(answer.equals("y"))
    {
        int ranVal = (int) (Math.random() * 6) + 1;
        System.out.println("The point to match is " + ranVal); // "your" random value has been created

        int computerValue = 7; //choosing number that's not on the die 
        int counter = 0; //keep track of computer attempts to match your point
        while(computerValue != ranVal)
        {
            counter++;
            computerValue= (int) (Math.random() * 6) + 1;//computerValue set = to generate number between 1-6
            System.out.println("roll #:" + counter + " is a " + computerValue);//print out "roll " + counter "is a " + computerValue
            
            //basically as soon as computerValue == ranVal the while loop breaks
        }

        System.out.println("It took the computer " + counter + " tries to reach the point");
        System.out.println("Press 'y' to continue. \nPress any key to exit");
        
        answer = input.next();//userinput here y or n
    }
        System.out.println("Goodbye");
        input.close();
        
    }}